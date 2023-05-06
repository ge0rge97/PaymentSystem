package com.george.spring.paymentSystem.service.impl;

import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.repository.UserRepository;
import com.george.spring.paymentSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not Found."));
    }
    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not Found."));
    }
    @Override
    public User create(User user) {
        userRepository.create(user);
        return user;
    }
    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
