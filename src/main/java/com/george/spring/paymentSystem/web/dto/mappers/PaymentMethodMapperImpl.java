package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.paymentMethod.Account;
import com.george.spring.paymentSystem.domain.paymentMethod.Card;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import com.george.spring.paymentSystem.web.dto.paymentMethod.AccountDto;
import com.george.spring.paymentSystem.web.dto.paymentMethod.CardDto;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;

public class PaymentMethodMapperImpl implements PaymentMethodMapper {
    @Override
    public PaymentMethod toEntity(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod;
        if (paymentMethodDto.getType() == PaymentMethodType.ACCOUNT) {
            paymentMethod = new Account();
        } else if (paymentMethodDto.getType() == PaymentMethodType.CARD) {
            paymentMethod = new Card();
        } else {
            throw new IllegalArgumentException("Invalid payment type: " + paymentMethodDto.getType());
        }
        paymentMethod.setId(paymentMethodDto.getId());
        paymentMethod.setNumber(paymentMethodDto.getNumber());
        paymentMethod.setCurrentBalance(paymentMethodDto.getCurrentBalance());
        paymentMethod.setPaymentMethodType(paymentMethodDto.getPaymentMethodType());
        paymentMethod.setUser(paymentMethodDto.getUser());
        return paymentMethod;
    }

    @Override
    public PaymentMethodDto toDto(PaymentMethod paymentMethod) {
        PaymentMethodDto paymentMethodDto;
        if (paymentMethod.getType() == PaymentMethodType.ACCOUNT) {
            paymentMethodDto = new AccountDto();
        } else if (paymentMethod.getType() == PaymentMethodType.CARD) {
            paymentMethodDto = new CardDto();
        } else {
            throw new IllegalArgumentException("Invalid payment type: " + paymentMethod.getType());
        }
        paymentMethodDto.setId(paymentMethod.getId());
        paymentMethodDto.setNumber(paymentMethod.getNumber());
        paymentMethodDto.setCurrentBalance(paymentMethod.getCurrentBalance());
        paymentMethodDto.setPaymentMethodType(paymentMethod.getType());
        paymentMethodDto.setUser(paymentMethod.getUser());
        return paymentMethodDto;
    }
}

