package com.example.Back.controller;

import com.example.Back.entity.VaccationType;
import com.example.Back.services.VaccationTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccation/type")
@CrossOrigin()
public class VaccationTypeController {
    @Autowired
    VaccationTypeServices vaccationTypeServices;

    @GetMapping("/all")
    public List<VaccationType> vaccationTypeList(){
        return vaccationTypeServices.all();
    }
}
