package com.george.spring.paymentSystem.service.impl;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.exception.ResourceNotFoundException;
import com.george.spring.paymentSystem.repository.PaymentRepository;
import com.george.spring.paymentSystem.repository.UserRepository;
import com.george.spring.paymentSystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not Found."));
    }
    @Override
    public List<Payment> getAllByUserId(Long userId) {
        return paymentRepository.findAllByUserId(userId);
    }
    @Override
    public Payment create(Payment payment, Long receiverId, Long senderId) {
        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new ResourceNotFoundException("Receiver not Found."));
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new ResourceNotFoundException("Sender not Found."));
        payment.setReceiver(receiver);
        payment.setSender(sender);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.create(payment, receiverId, senderId);
        return payment;
    }
    @Override
    public void delete(Long id) { paymentRepository.delete(id); }
}
