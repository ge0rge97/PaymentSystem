package com.george.spring.paymentSystem.web.dto.paymentMethod;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;

public class CardDto extends PaymentMethodDto {
    @Override
    public PaymentMethodType getType() {
        return PaymentMethodType.CARD;
    }
}
