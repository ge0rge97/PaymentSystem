package com.george.spring.paymentSystem.service;

import com.george.spring.paymentSystem.web.dto.auth.JwtRequest;
import com.george.spring.paymentSystem.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest request);
    JwtResponse refresh(String refreshToken);
}
