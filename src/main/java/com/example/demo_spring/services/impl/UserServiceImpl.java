package com.example.demo_spring.services.impl;

import com.example.demo_spring.dto.request.UserRegisterRequest;
import com.example.demo_spring.dto.response.UserRegistrationResponse;
import com.example.demo_spring.models.User;
import com.example.demo_spring.repositories.UserRepository;
import com.example.demo_spring.services.UserService;
import com.example.demo_spring.util.MailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final  UserRepository userRepository;
    private final MailUtil mailUtil;


    @Override
    public UserRegistrationResponse register(UserRegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            return UserRegistrationResponse.builder()
                    .message("Email already exist")
                    .build();
        }else {
            UUID token = UUID.randomUUID();
            String mailBody = "To verify your registration please click on link or ignore it "+
                    "http://localhost:8090/user/activate?token="+token;
            userRepository.save(User.builder()
                    .activationToken(token.toString())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .name(request.getName())
                    .surname(request.getSurname())
                    .age(request.getAge())
                    .gender(request.getGender())
                    .build());
            Runnable thread =()->{

                mailUtil.sendEmail(request.getEmail(), "Account activation", mailBody);
            };
            new Thread(thread).start();
            return UserRegistrationResponse.builder()
                    .success(true)
                    .message("Check you email")
                    .build();
        }
    }

    @Override
    public String activate(String token) {
        Optional<User> byActivationToken = userRepository.findByActivationToken(token);
        if(byActivationToken.isPresent()){
            User user = byActivationToken.get();
            user.setActivationToken(null);
            userRepository.save(user);
            return "You succesfully activated your account.";
        }
        return "Something went wrong";
    }
}
