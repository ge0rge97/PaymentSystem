package com.george.spring.paymentSystem.web.dto.auth;

import lombok.Data;

@Data
public class JwtResponse {
    private String username;
    private String password;
    private String accessToken;
    private String refreshToken;
}
