package com.george.spring.paymentSystem.web.dto.payment;

import com.george.spring.paymentSystem.domain.user.User;

import java.time.LocalDateTime;

public class PaymentDto {
    private Long id;
    private LocalDateTime date;
    private Double amount;
    private User receiver;
    private User sender;
}
