package com.example.Back.services;

import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import com.example.Back.handler.PreventSaveException;
import com.example.Back.repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesServices {
    @Autowired
    RolesRepo rolesRepo;

    public void save(Roles roles) {
        rolesRepo.save(roles);
    }

    public Optional<Roles>findByName(String name){
        return rolesRepo.findByName(name);
    }

    public Iterable<Roles> all(){
        return rolesRepo.findAll();
    }

    public Roles findById(Long id) throws PreventSaveException {
        return rolesRepo.findById(id).orElseThrow(()-> new PreventSaveException("There Is No Role With This Id"));
    }
}
