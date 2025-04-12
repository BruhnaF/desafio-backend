package com.simplesdental.product.service.users;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.simplesdental.product.model.User;
import com.simplesdental.product.repository.UserRepository;
import com.simplesdental.product.service.ObjectsValidator;
import com.simplesdental.product.service.Result;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ObjectsValidator<RegisterRequest> postValidator;
    
    public Result<RegisterResponse> save(RegisterRequest user) {
        Result<RegisterResponse> response = new Result<RegisterResponse>();
        var violations = postValidator.validate(user);

        if (!violations.isEmpty()) {            
            response.setErrors(new ArrayList<>(violations));
        }

        User newUser = userRepository.save(user.toModel());
        RegisterResponse userResponse = new RegisterResponse(newUser);

        response.setData(userResponse);
        return response;
    }
}
