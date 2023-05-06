package com.george.spring.paymentSystem.service;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod getById(Long id);
    PaymentMethod getByNumber(Long number);
    List<PaymentMethod> getAllByUserId(Long userId);
    PaymentMethod create(PaymentMethod paymentMethod, Long userId);
    void delete(Long id);
}
