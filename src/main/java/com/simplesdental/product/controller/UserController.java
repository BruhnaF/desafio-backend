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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Tag(name = "post", description = "POST methods of create User")
    @Operation(summary = "create a user", description = "create a new user.")
    @PostMapping("/auth/register")
    public ResponseEntity<Object> createUser(
            @Parameter(description = "data for create user", required = true) @RequestBody RegisterRequest entity) {
        Result<RegisterResponse> response = userService.save(entity);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response.getErrors());
        }
        return ResponseEntity.ok(response.getData());
    }

}
