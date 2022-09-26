package com.example.demo_spring.advice;

import com.example.demo_spring.exceptions.UserNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class AppExceptionHandler {


//    @ExceptionHandler(HttpMessageNotWritableException.class)
//    public String handleHttpMessageNotWritableException(HttpMessageNotWritableException exception){
//        return exception.getMessage();
//    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Optional handleHttpMessageNotWritableException(Exception exception){
        return Optional.of(exception.getMessage());
//        ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(exception.getMessage());
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Optional<String> userNotFound(UserNotFoundException exception){
        return Optional.of(exception.getMessage());
//        ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(exception.getMessage());
    }



}
