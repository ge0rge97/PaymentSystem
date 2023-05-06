package com.george.spring.paymentSystem.service.impl;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.repository.PaymentMethodRepository;
import com.george.spring.paymentSystem.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod getById(Long id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Method not Found."));
    }
    @Override
    public PaymentMethod getByNumber(Long number) {
        return paymentMethodRepository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Payment Method not Found."));
    }
    @Override
    public List<PaymentMethod> getAllByUserId(Long userId) {
        return paymentMethodRepository.findAllByUserId(userId);
    }
    @Override
    public PaymentMethod create(PaymentMethod paymentMethod, Long userId) {
        paymentMethodRepository.create(paymentMethod, userId);
        return paymentMethod;
    }
    @Override
    public void delete(Long id) {
        paymentMethodRepository.delete(id);
    }
}
