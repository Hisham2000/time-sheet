package com.example.Back.controller;

import com.example.Back.entity.Roles;
import com.example.Back.services.RolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/api/rolles")
public class RollesController {

    @Autowired
    RolesServices rolesServices;

    @Secured("HR")
    @GetMapping("/all")
    public Iterable<Roles> all(){
        return rolesServices.all();
    }
}
