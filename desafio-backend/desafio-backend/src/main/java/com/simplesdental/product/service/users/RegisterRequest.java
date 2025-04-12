package com.simplesdental.product.service.users;

import com.simplesdental.product.model.User;
import com.simplesdental.product.service.ValuesAllowed;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "name required")
    @Size(max = 255, message = "name must be least 255 characters")
    private String name;
    @NotBlank(message = "email required")
    @Email(message = "Email is invalid")
    @Size(max = 255, message = "email must be least 255 characters")
    private String email;
    @NotBlank(message = "password required")
    @Size(max = 255, message = "password must be least 255 characters")
    private String password;
    @NotBlank(message = "role required")
    @Size(max = 5, message = "role must be less than 5 characters")
    @ValuesAllowed(propName = "role", values = { "admin", "user" })
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
