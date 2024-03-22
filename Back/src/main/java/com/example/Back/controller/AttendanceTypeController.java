package com.example.Back.controller;

import com.example.Back.services.AttendanceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/attendance-type", produces = "application/json")
public class AttendanceTypeController {
    @Autowired
    private AttendanceTypeService attendanceTypeService;

    @GetMapping("all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(attendanceTypeService.findAll());
    }
}
