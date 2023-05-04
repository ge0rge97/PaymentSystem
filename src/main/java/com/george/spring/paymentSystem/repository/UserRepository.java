package com.george.spring.paymentSystem.repository;


import com.george.spring.paymentSystem.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    void create(User user);
    void delete(Long id);
}
