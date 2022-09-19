package com.example.demo_spring.repositories;

import com.example.demo_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    User findByEmailAndActivationTokenOrAgeGreaterThan(String emai, UUID toke, int age);
}
