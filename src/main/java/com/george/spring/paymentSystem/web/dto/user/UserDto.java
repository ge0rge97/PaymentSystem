package com.george.spring.paymentSystem.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private Long id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;
}
