package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.paymentMethod.Card;
import com.george.spring.paymentSystem.web.dto.paymentMethod.CardDto;

public interface CardMapper {
    Card toEntity(CardDto cardDto);
    CardDto toDto(Card card);
}
