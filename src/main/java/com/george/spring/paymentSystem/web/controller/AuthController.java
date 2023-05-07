package com.george.spring.paymentSystem.web.controller;


import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.service.UserService;
import com.george.spring.paymentSystem.web.dto.mappers.UserMapper;
import com.george.spring.paymentSystem.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }
}
