package com.george.spring.paymentSystem.service.impl;

import com.george.spring.paymentSystem.service.AuthService;
import com.george.spring.paymentSystem.web.dto.auth.JwtRequest;
import com.george.spring.paymentSystem.web.dto.auth.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest request) {
        return null;
    }
    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
