package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.paymentMethod.Account;
import com.george.spring.paymentSystem.domain.paymentMethod.Card;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import com.george.spring.paymentSystem.web.dto.paymentMethod.PaymentMethodDto;
import org.mapstruct.MapperConfig;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {Card.class, Account.class}
)
public interface PaymentMethodMapperConfig {

    @Named("createCard")
    default Card createCard(Object o) {
        return new Card();
    }

    @Named("createAccount")
    default Account createAccount(Object o) {
        return new Account();
    }
}
