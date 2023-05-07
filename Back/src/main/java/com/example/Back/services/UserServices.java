package com.example.Back.services;

import com.example.Back.config.SendEmailService;
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
    @Autowired
    SendEmailService sendEmailService;
    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findUserByName(String email){
        return userRepo.findUsersByEmail(email);
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode("123456789"));
//        String body = "User Name: " + user.getName() + "\n Email: "+ user.getEmail() + "\n password: 123456789";
//        sendEmailService.sendEmail(user.getEmail(),
//                "Account Details on Time Sheet", body);
        userRepo.save(user);
    }

    public User findByEmail(String email){
        return userRepo.findUsersByEmail(email).get();
    }

    public User findById(Long id){
        return userRepo.findById(id).get();
    }

    public Iterable<User> delete(Long id){
        userRepo.deleteById(id);
        return userRepo.findAll();
    }
}
