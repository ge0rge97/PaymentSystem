package com.george.spring.paymentSystem.service.impl;

import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.exception.ResourceNotFoundException;
import com.george.spring.paymentSystem.repository.UserRepository;
import com.george.spring.paymentSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found."));
    }
    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found."));
    }
    @Override
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User already exists.");
        }
        if (user.getPassword() != user.getPasswordConfirmation()) {
            throw new IllegalStateException("Password do not match.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.create(user);
        return user;
    }
    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
