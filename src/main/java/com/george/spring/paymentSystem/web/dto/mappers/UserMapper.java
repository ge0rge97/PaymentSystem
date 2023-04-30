package com.george.spring.paymentSystem.web.dto.mappers;

import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
