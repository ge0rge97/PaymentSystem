package com.george.spring.paymentSystem.domain.paymentMethod;

import lombok.Data;

@Data
public class Account extends PaymentMethod {
    @Override
    public PaymentMethodType getType() {
        return PaymentMethodType.ACCOUNT;
    }
}