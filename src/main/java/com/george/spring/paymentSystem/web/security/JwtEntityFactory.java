package com.george.spring.paymentSystem.web.security;


import com.george.spring.paymentSystem.domain.user.User;

public class JwtEntityFactory {
    public static JwtEntity create(User user) {
        return new JwtEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
