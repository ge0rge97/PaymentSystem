package com.george.spring.paymentSystem.repository;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository {
    Optional<PaymentMethod> findById(Long id);
    Optional<PaymentMethod> findByNumber(Long number);
    List<PaymentMethod> findAllByUserId(Long userId);
    void create(PaymentMethod paymentMethod, Long userId);
    void delete(Long id);
}
