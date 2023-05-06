package com.george.spring.paymentSystem.service;

import com.george.spring.paymentSystem.domain.payment.Payment;

import java.util.List;

public interface PaymentService {
    Payment getById(Long id);
    List<Payment> getAllByUserId(Long userId);
    Payment create(Payment payment, Long receiverId, Long senderId);
    void delete(Long id);
}
