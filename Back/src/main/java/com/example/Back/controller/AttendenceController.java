package com.example.Back.controller;

import com.example.Back.entity.Attendence;
import com.example.Back.services.AttendenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/attendant")
@CrossOrigin()
public class AttendenceController {
    @Autowired
    AttendenceServices attendenceServices;

    @PostMapping("enter")
    public Attendence attend(@RequestHeader HashMap headers){
        return attendenceServices.save(headers);
    }

    @PostMapping("leave")
    public Attendence leave(@RequestHeader HashMap headers){
        return attendenceServices.updateLeave(headers);
    }

    @GetMapping("/user")
    public Set<LocalDate> attendenceUser(@RequestHeader HashMap headers)
    {
        return attendenceServices.attendenceUser(headers);
    }
}
