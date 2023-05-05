package com.george.spring.paymentSystem.repository;

import com.george.spring.paymentSystem.domain.payment.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Optional<Payment> findById(Long id);
    List<Payment> findAllByUserId(Long id);
    void create(Payment payment, Long receiverId, Long senderId);
    void delete(Long id);
}
