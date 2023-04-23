package com.example.Back.repository;

import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Long> {
    public Optional<Roles> findByName(String name);
}
