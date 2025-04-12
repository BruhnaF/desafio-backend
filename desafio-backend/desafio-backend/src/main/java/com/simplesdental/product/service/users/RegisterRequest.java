package com.simplesdental.product.service.users;

import com.simplesdental.product.model.User;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role;

    public User toModel() {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);
        return newUser;
    }
}
