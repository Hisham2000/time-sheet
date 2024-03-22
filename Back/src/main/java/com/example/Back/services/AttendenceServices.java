package com.example.Back.services;

import com.example.Back.entity.Attendance;
import com.example.Back.entity.User;
import com.example.Back.repository.AttendenceRepo;
import com.example.Back.secuirty.JwtTokenUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;


import java.util.HashMap;
import java.util.Set;

@Service
public class AttendenceServices {
    @Autowired
    AttendenceRepo attendenceRepo;

    @Autowired
    JwtTokenUtilities jwtTokenUtilities;
    @Autowired
    UserServices userServices;

    public Attendance save(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        Attendance attendance = attendenceRepo.save(new Attendance(LocalDate.now(), LocalTime.now(), null, user));
        return attendance;
    }

    public Attendance updateLeave(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        Attendance attendance = attendenceRepo.findAttendencesByUserIdAndDay(user.getId(), LocalDate.now());
        attendance.setLeaveTime(LocalTime.now());
        return attendenceRepo.save(attendance);
    }

    public Set<LocalDate> attendenceUser(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return  attendenceRepo.findAttendencesByUserId(user.getId());
    }
}
