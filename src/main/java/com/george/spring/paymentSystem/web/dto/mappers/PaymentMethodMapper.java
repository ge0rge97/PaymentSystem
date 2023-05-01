package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethod toEntity(PaymentMethodDto paymentMethodDto);
    PaymentMethodDto toDto(PaymentMethod paymentMethod);
    List<PaymentMethod> toEntity(List<PaymentMethodDto> paymentMethodDto);
    List<PaymentMethodDto> toDto(List<PaymentMethod> paymentMethod);
}

