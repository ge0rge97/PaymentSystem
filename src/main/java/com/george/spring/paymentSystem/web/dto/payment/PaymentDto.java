package com.george.spring.paymentSystem.web.dto.payment;

import com.george.spring.paymentSystem.web.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {
    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private UserDto sender;
    private UserDto receiver;
}
