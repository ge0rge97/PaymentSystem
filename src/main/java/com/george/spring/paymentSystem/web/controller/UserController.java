package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.service.PaymentMethodService;
import com.george.spring.paymentSystem.service.PaymentService;
import com.george.spring.paymentSystem.service.UserService;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMapper;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMethodMapper;
import com.george.spring.paymentSystem.web.dto.mappers.UserMapper;
import com.george.spring.paymentSystem.web.dto.payment.PaymentDto;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;
import com.george.spring.paymentSystem.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PaymentMethodService paymentMethodService;
    private final PaymentService paymentService;
    private final UserMapper userMapper;
    private final PaymentMethodMapper paymentMethodMapper;
    private final PaymentMapper paymentMapper;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }
    @GetMapping("/{id}/paymentMethods")
    public List<PaymentMethodDto> getPaymentMethodsById(@PathVariable Long id) {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllByUserId(id);
        return paymentMethodMapper.toDto(paymentMethods);
    }
    @GetMapping("/{id}/payments")
    public List<PaymentDto> getPayments(@PathVariable Long id) {
        List<Payment> payments = paymentService.getAllByUserId(id);
        return paymentMapper.toDto(payments);
    }
    @PostMapping("/{id}/paymentMethods")
    public PaymentMethodDto createPaymentMethod(@PathVariable Long id,
                                                @RequestBody PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(paymentMethodDto);
        PaymentMethod createdPaymentMethod = paymentMethodService.create(paymentMethod, id);
        return paymentMethodMapper.toDto(createdPaymentMethod);
    }
    @PostMapping("/{senderId}/payment/{receiverId}")
    public PaymentDto createPayment(@PathVariable Long senderId,
                                    @PathVariable Long receiverId,
                                    @RequestBody PaymentDto paymentDto) {
        Payment payment = paymentMapper.toEntity(paymentDto);
        Payment createdPayment = paymentService.create(payment, receiverId, senderId);
        return  paymentMapper.toDto(createdPayment);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
