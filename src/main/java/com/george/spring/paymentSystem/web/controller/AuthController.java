package com.george.spring.paymentSystem.web.controller;


import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.service.AuthService;
import com.george.spring.paymentSystem.service.UserService;
import com.george.spring.paymentSystem.web.dto.auth.JwtRequest;
import com.george.spring.paymentSystem.web.dto.auth.JwtResponse;
import com.george.spring.paymentSystem.web.dto.mappers.UserMapper;
import com.george.spring.paymentSystem.web.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller.", description = "AUTH API.")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    @Operation(summary = "Login user.")
    public JwtResponse login(@RequestBody JwtRequest request) { return authService.login(request); }
    @PostMapping("/register")
    @Operation(summary = "Register new user.")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }
    @PostMapping("/refresh")
    @Operation(summary = "Register user token.")
    public JwtResponse refreshToken(@RequestBody String refreshToken) { return authService.refresh(refreshToken); }
}
