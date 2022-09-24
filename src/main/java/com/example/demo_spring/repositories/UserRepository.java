package com.example.demo_spring.repositories;

import com.example.demo_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    Optional<User> findByActivationToken(String token);

    @Modifying
    @Transactional
    void deleteAllByCreatedBeforeAndActivationTokenIsNotNull(LocalDateTime created);
    User findByEmailAndActivationTokenOrAgeGreaterThan(String emai, UUID toke, int age);

//    @Query(value = "select * from users u where u.age=:p", nativeQuery = true)
//    List<User> poxos(@Param("p") int age);
}
