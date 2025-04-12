package com.simplesdental.product.service.users;

import com.simplesdental.product.model.User;

import lombok.Data;

@Data
public class RegisterResponse {

    public RegisterResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    private Long id;
    private String name;
    private String email;
    private String role;
}
