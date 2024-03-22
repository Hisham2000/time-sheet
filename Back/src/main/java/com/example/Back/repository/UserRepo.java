package com.example.Back.repository;

import com.example.Back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUsersByEmail(String email);
    Optional<User> findByEmail(String email);

}
