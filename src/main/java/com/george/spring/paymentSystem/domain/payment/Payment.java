package com.george.spring.paymentSystem.domain.payment;

import com.george.spring.paymentSystem.domain.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payment {
    private Long id;
    private LocalDateTime date;
    private Double amount;
    private User receiver;
    private User sender;
}
