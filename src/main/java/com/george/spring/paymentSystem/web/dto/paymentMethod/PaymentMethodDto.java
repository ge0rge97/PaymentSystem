package com.george.spring.paymentSystem.web.dto.paymentMethod;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import com.george.spring.paymentSystem.domain.user.User;
import lombok.Data;

@Data
public abstract class PaymentMethodDto {
    private Long id;
    private Long number;
    private Double currentBalance;
    private PaymentMethodType paymentMethodType;
    private User user;
    public abstract PaymentMethodType getType();
}
