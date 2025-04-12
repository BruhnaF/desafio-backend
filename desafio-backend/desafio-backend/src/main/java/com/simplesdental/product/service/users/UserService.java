package com.simplesdental.product.service.users;

import org.springframework.stereotype.Service;

import com.simplesdental.product.model.User;
import com.simplesdental.product.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public RegisterResponse save(RegisterRequest user) {
        User newUser = userRepository.save(user.toModel());
        return new RegisterResponse(newUser);
    }
}
