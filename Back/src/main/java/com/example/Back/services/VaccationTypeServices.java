package com.example.Back.services;

import com.example.Back.entity.VacationType;
import com.example.Back.repository.VaccationTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccationTypeServices {
    @Autowired
    VaccationTypeRepo vaccationTypeRepo;
    public VacationType save(VacationType vacationType){
        return vaccationTypeRepo.save(vacationType);
    }

    public List<VacationType> all() {
        return vaccationTypeRepo.findAll();
    }
}
