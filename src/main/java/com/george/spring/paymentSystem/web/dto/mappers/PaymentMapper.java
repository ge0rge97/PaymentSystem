package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.web.dto.payment.PaymentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentDto paymentDto);
    PaymentDto toDto(Payment payment);
    List<Payment> toEntity(List<PaymentDto> paymentDto);
    List<PaymentDto> toDto(List<Payment> payment);
}
