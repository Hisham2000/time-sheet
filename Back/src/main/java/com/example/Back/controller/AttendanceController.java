package com.example.Back.controller;

import com.example.Back.entity.Attendance;
import com.example.Back.services.AttendenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/attendant")
@CrossOrigin(origins = "http://localhost:4200")
public class AttendanceController {
    @Autowired
    AttendenceServices attendenceServices;

    @PostMapping("enter")
    public Attendance attend(@RequestHeader HashMap headers){
        return attendenceServices.save(headers);
    }

    @PostMapping("leave")
    public Attendance leave(@RequestHeader HashMap headers){
        return attendenceServices.updateLeave(headers);
    }

    @GetMapping("/user")
    public Set<LocalDate> attendenceUser(@RequestHeader HashMap headers)
    {
        return attendenceServices.attendenceUser(headers);
    }
}
