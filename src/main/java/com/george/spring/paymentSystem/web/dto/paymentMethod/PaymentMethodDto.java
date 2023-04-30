package com.george.spring.paymentSystem.web.dto.paymentMethod;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import com.george.spring.paymentSystem.domain.user.User;

public class PaymentMethodDto {
    private Long id;
    private Long number;
    private PaymentMethodType paymentMethodType;
    private User user;
}
