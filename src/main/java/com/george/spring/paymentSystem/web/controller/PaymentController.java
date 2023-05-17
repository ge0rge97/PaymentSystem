package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.service.PaymentService;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMapper;
import com.george.spring.paymentSystem.web.dto.payment.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payments")
@RequiredArgsConstructor
@Tag(name = "Payment Controller.", description = "Payment API.")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Get payment by id.")
    public PaymentDto getById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        return paymentMapper.toDto(payment);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete payment by id.")
    public void deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
