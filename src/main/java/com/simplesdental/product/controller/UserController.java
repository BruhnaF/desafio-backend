package com.simplesdental.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplesdental.product.service.Result;
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
    public ResponseEntity<Object> createUser(@RequestBody RegisterRequest entity) {
        Result<RegisterResponse> response = userService.save(entity);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response.getErrors());
        }
        return ResponseEntity.ok(response.getData());
    }

}
