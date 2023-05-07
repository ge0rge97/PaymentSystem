package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.service.PaymentService;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMapper;
import com.george.spring.paymentSystem.web.dto.payment.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping("/{id}")
    public PaymentDto getById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        return paymentMapper.toDto(payment);
    }
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
