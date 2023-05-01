package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.paymentMethod.Account;
import com.george.spring.paymentSystem.domain.paymentMethod.Card;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import com.george.spring.paymentSystem.web.dto.paymentMethod.AccountDto;
import com.george.spring.paymentSystem.web.dto.paymentMethod.CardDto;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;
import org.mapstruct.*;
import org.springframework.beans.BeanUtils;

import java.util.List;


public interface PaymentMethodMapper {
    PaymentMethod toEntity(PaymentMethodDto paymentMethodDto);
    PaymentMethodDto toDto(PaymentMethod paymentMethod);
}

