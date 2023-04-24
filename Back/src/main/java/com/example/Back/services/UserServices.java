package com.example.Back.services;

import com.example.Back.entity.User;
import com.example.Back.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findUserByName(String email){
        return userRepo.findUsersByEmail(email);
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public User findByEmail(String email){
        return userRepo.findUsersByEmail(email).get();
    }

    public User findById(Long id){
        return userRepo.findById(id).get();
    }
}
