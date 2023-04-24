package com.example.Back.services;

import com.example.Back.entity.Attendence;
import com.example.Back.entity.User;
import com.example.Back.repository.AttendenceRepo;
import com.example.Back.secuirty.JwtTokenUtilies;
import com.example.Back.secuirty.SecuirtyConfigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;


import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@Service
public class AttendenceServices {
    @Autowired
    AttendenceRepo attendenceRepo;

    @Autowired
    JwtTokenUtilies jwtTokenUtilies;
    @Autowired
    UserServices userServices;

    public Attendence save(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilies.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        Attendence attendence = attendenceRepo.save(new Attendence(LocalDate.now(), LocalTime.now(), null, user));
        return attendence;
    }

    public Attendence updateLeave(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilies.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        Attendence attendence = attendenceRepo.findAttendencesByUserIdAndDay(user.getId(), LocalDate.now());
        attendence.setLeaveTime(LocalTime.now());
        return attendenceRepo.save(attendence);
    }

    public Set<LocalDate> attendenceUser(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilies.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return  attendenceRepo.findAttendencesByUserId(user.getId());
    }
}
