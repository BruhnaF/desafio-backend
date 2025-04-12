package com.simplesdental.product.service.users;

import org.springframework.stereotype.Service;

import com.simplesdental.product.model.User;
import com.simplesdental.product.repository.UserRepository;
import com.simplesdental.product.service.Result;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Result<RegisterResponse> save(RegisterRequest user) {
        User newUser = userRepository.save(user.toModel());
        RegisterResponse userResponse = new RegisterResponse(newUser);
        
        Result<RegisterResponse> response = new Result<RegisterResponse>();
        response.setData(userResponse);
        return response;
    }
}
