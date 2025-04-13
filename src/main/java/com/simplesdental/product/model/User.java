package com.simplesdental.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name", length = 255)
    private String name;

    @NotBlank
    @Column(name = "email", length = 255)
    private String email;

    @NotBlank
    @Column(name = "password", length = 255)
    private String password;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
