package com.example.demo_spring.schedulers;

import com.example.demo_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppScheduler {

    @Value("${test.test}")
    private String poxos;

    @Autowired
    private UserRepository userRepository;

    @Scheduled(fixedDelayString = "${inactivate.users.delay}")
    public void scheduleFixedDelayTask() {
        System.out.println("*** "+poxos);
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        userRepository.deleteAllByCreatedBeforeAndActivationTokenIsNotNull(LocalDateTime.now().minusMinutes(5));
    }
}
