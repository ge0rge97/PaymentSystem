package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.service.PaymentMethodService;
import com.george.spring.paymentSystem.service.UserService;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMethodMapper;
import com.george.spring.paymentSystem.web.dto.mappers.UserMapper;
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
    private final UserMapper userMapper;
    private final PaymentMethodMapper paymentMethodMapper;

    @GetMapping("{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }
    @GetMapping("/{id}/paymentMethods")
    public List<PaymentMethodDto> getPaymentMethodsById(@PathVariable Long id) {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllByUserId(id);
        return paymentMethodMapper.toDto(paymentMethods);
    }
    @PostMapping("/{id}/paymentMethods")
    public PaymentMethodDto createPaymentMethod(@PathVariable Long id,
                                                @RequestBody PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(paymentMethodDto);
        PaymentMethod createdPaymentMethod = paymentMethodService.create(paymentMethod, id);
        return paymentMethodMapper.toDto(createdPaymentMethod);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
