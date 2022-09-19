package com.example.demo_spring.dto.request;

import com.example.demo_spring.models.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserRegisterRequest {

    private String name;

    private String surname;

    private String email;

    private String password;

    private int age;

    private Gender gender;

}
