package com.george.spring.paymentSystem.web.controller;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.service.PaymentMethodService;
import com.george.spring.paymentSystem.web.dto.mappers.PaymentMethodMapper;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/paymentMethods")
@RequiredArgsConstructor
@Tag(name = "Payment Method Controller.", description = "Payment Method API.")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodMapper paymentMethodMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Get payment method by id.")
    public PaymentMethodDto getById(@PathVariable Long id) {
        PaymentMethod paymentMethod = paymentMethodService.getById(id);
        return paymentMethodMapper.toDto(paymentMethod);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete payment method by id.")
    public void deletePaymentMethodById(@PathVariable Long id) {
        paymentMethodService.delete(id);
    }
}
