package com.example.demo_spring.services;

import com.example.demo_spring.dto.request.UserRegisterRequest;
import com.example.demo_spring.dto.response.UserRegistrationResponse;

public interface UserService {

    UserRegistrationResponse register(UserRegisterRequest request);
}
