package com.george.spring.paymentSystem.service.impl;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {


    @Override
    public Payment getById(Long id) {
        return null;
    }
    @Override
    public List<Payment> getAllByUserId(Long userId) {
        return null;
    }
    @Override
    public Payment create(Payment payment, Long receiverId, Long senderId) {
        return null;
    }
    @Override
    public void delete(Long id) {

    }
}
