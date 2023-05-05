package com.george.spring.paymentSystem.repository;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;

import java.util.Optional;

public interface PaymentMethodRepository {
    Optional<PaymentMethod> findById(Long id);
    Optional<PaymentMethod> findByNumber(Long number);
    Optional<PaymentMethod> findAllByUserId(Long userId);
    void create(PaymentMethod paymentMethod);
    void delete(PaymentMethod paymentMethod);
}
