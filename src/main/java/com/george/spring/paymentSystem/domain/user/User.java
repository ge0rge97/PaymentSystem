package com.george.spring.paymentSystem.domain.user;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirmation;
    private List<PaymentMethod> paymentMethods;
    private List<Payment> paymentsHistory;
}
