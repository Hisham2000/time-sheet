package com.example.Back.controller;

import com.example.Back.entity.Attendance;
import com.example.Back.services.AttendenceServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/attendant", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class AttendanceController {
    @Autowired
    AttendenceServices attendenceServices;

    @PostMapping("enter/{typeID}")
    public ResponseEntity attend(@PathVariable Long typeID) throws Exception {
        return ResponseEntity.ok(attendenceServices.save(typeID));
    }

    @GetMapping("last-enter")
    public ResponseEntity getLastEnter() throws ParseException {
        return ResponseEntity.ok(attendenceServices.getTheLastTodayAttendance());
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
