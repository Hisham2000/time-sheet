package com.example.Back.services;

import com.example.Back.entity.VaccationType;
import com.example.Back.repository.VaccationTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccationTypeServices {
    @Autowired
    VaccationTypeRepo vaccationTypeRepo;
    public VaccationType save(VaccationType vaccationType){
        return vaccationTypeRepo.save(vaccationType);
    }

    public List<VaccationType> all() {
        return vaccationTypeRepo.findAll();
    }
}
