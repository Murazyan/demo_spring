package com.example.demo_spring.dto.response;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {

    private boolean success;

    private String message;

    private int id;
}
