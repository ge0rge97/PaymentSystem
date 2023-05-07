package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.service.PaymentMethodService;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMethodMapper;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/paymentMethods")
@RequiredArgsConstructor
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodMapper paymentMethodMapper;

    @GetMapping("/{id}")
    public PaymentMethodDto getById(@PathVariable Long id) {
        PaymentMethod paymentMethod = paymentMethodService.getById(id);
        return paymentMethodMapper.toDto(paymentMethod);
    }
}
