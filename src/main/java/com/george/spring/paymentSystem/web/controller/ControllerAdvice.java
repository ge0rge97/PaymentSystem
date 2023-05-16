package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.exception.AccessDeniedException;
import com.george.spring.paymentSystem.exception.ExceptionBody;
import com.george.spring.paymentSystem.exception.ResourceMappingException;
import com.george.spring.paymentSystem.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleNotFoundException(ResourceNotFoundException exception) {
        return new ExceptionBody(exception.getMessage());
    }
    @ExceptionHandler(ResourceMappingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleResourceMappingException(ResourceMappingException exception) {
        return new ExceptionBody(exception.getMessage());
    }
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleIllegalStateException(IllegalStateException exception) {
        return new ExceptionBody(exception.getMessage());
    }
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionBody handleAccessDeniedException(AccessDeniedException exception) {
        return new ExceptionBody(exception.getMessage());
    }
    @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionBody handleAccessDeniedException() {
        return new ExceptionBody("Access Denied.");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleArgumentNotValidException (MethodArgumentNotValidException exception) {
        ExceptionBody exceptionBody = new ExceptionBody("Validation Failed.");
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        exceptionBody.setErrors(errors.stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        return exceptionBody;
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleConstraintViolationException(ConstraintViolationException exception) {
        ExceptionBody exceptionBody = new ExceptionBody("Validation Failed.");
        exceptionBody.setErrors(exception.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        violation ->violation.getMessage()
                )));
        return exceptionBody;
    }
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleAuthenticationException(AuthenticationException exception) {
        return new ExceptionBody(exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleException(Exception exception) {
        return new ExceptionBody("Internal Error.");
    }
}
