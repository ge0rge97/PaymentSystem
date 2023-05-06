package com.george.spring.paymentSystem.service;

import com.george.spring.paymentSystem.domain.user.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User create(User user);
    void delete(Long id);
}
