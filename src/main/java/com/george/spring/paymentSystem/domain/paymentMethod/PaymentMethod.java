package com.george.spring.paymentSystem.domain.paymentMethod;

import com.george.spring.paymentSystem.domain.user.User;
import lombok.Data;

@Data
public abstract class PaymentMethod {
    private Long id;
    private Long number;
    private Double currentBalance;
    private User user;
    public abstract PaymentMethodType getType();
}
