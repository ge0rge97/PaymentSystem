package com.george.spring.paymentSystem.web.dto.payment;

import com.george.spring.paymentSystem.domain.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {
    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private User receiver;
    private User sender;
}
