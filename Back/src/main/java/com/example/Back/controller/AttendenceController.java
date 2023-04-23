package com.example.Back.controller;

import com.example.Back.entity.Attendence;
import com.example.Back.services.AttendenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/attendant")
@CrossOrigin()
public class AttendenceController {
    @Autowired
    AttendenceServices attendenceServices;

    @PostMapping("enter")
    public void attend(@RequestHeader HashMap headers){
        Attendence attendence = attendenceServices.save(headers);
    }
}
