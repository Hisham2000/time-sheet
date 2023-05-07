package com.example.Back.controller;

import com.example.Back.entity.User;
import com.example.Back.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin()
public class UserController {
    @Autowired
    UserServices userServices;

    @Secured("HR")
    @GetMapping("/all")
    public Iterable<User> all()
    {
        return userServices.getAll();
    }

    @Secured("HR")
    @GetMapping("/{id}")
    public Iterable<User> delete(@PathVariable Long id){
        return userServices.delete(id);
    }

    @Secured("HR")
    @GetMapping("/edit/{id}")
    public User findById(@PathVariable Long id){
        return userServices.findById(id);
    }
}
