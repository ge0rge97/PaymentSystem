package com.george.spring.paymentSystem.domain.paymentMethod;

import com.george.spring.paymentSystem.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class PaymentMethod {
    private Long id;
    private Long number;
    private Double currentBalance;
    private PaymentMethodType paymentMethodType;
    private User user;
    public abstract PaymentMethodType getType();
}
