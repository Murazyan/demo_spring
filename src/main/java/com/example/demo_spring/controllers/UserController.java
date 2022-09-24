package com.example.demo_spring.controllers;

import com.example.demo_spring.dto.request.UserRegisterRequest;
import com.example.demo_spring.dto.response.UserRegistrationResponse;
import com.example.demo_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserRegistrationResponse register(@RequestBody UserRegisterRequest request) {
        return userService.register(request);

    }

    @GetMapping("/activate")
    public String activate(@RequestParam("token") String token) {
        return userService.activate(token);
    }


}
