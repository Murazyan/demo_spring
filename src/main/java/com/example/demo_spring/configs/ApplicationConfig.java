package com.example.demo_spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ApplicationConfig {


    @Bean
    @Scope(scopeName = "prototype")
    public MyClass getMyClassdsgds(){
        return new MyClass();
    }
}
