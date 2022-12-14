package com.example.demo_spring.services;

import com.example.demo_spring.dto.request.AuthenticationRequest;
import com.example.demo_spring.dto.request.UserRegisterRequest;
import com.example.demo_spring.dto.response.AuthenticationResponse;
import com.example.demo_spring.dto.response.UserRegistrationResponse;

import java.util.UUID;

public interface UserService {

    UserRegistrationResponse register(UserRegisterRequest request);

    String activate(String token);

    AuthenticationResponse login(AuthenticationRequest request);
}
