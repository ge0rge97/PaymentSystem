package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.paymentMethod.Account;
import com.george.spring.paymentSystem.web.dto.paymentMethod.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDto accountDto);
    AccountDto toDto(Account account);
}
