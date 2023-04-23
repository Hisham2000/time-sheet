package com.example.Back.controller;

import com.example.Back.entity.User;
import com.example.Back.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping("")
    public Iterable<User> all()
    {
        return userServices.getAll();
    }
}
