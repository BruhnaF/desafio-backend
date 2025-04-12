package com.simplesdental.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplesdental.product.service.users.RegisterRequest;
import com.simplesdental.product.service.users.RegisterResponse;
import com.simplesdental.product.service.users.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/register")
    public RegisterResponse createUser(@RequestBody RegisterRequest entity) {
        return userService.save(entity);
    }

}
