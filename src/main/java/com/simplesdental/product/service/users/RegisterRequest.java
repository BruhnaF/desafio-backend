package com.simplesdental.product.service.users;

import com.simplesdental.product.model.RoleType;
import com.simplesdental.product.model.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "role required")
    @RolesAllowed(propName = "role", values = { RoleType.user, RoleType.admin })
    private RoleType role;

    public User toModel() {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);
        return newUser;
    }
}
