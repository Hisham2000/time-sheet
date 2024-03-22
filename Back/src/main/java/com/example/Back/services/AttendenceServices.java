package com.example.Back.services;

import com.example.Back.entity.Attendance;
import com.example.Back.entity.AttendanceType;
import com.example.Back.entity.User;
import com.example.Back.repository.AttendenceRepo;
import com.example.Back.secuirty.JwtTokenUtilities;
import com.example.Back.secuirty.SessionInfo;
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
    @Autowired
    SessionInfo sessionInfo;
    @Autowired
    AttendanceTypeService attendanceTypeService;

    public Attendance save(Long typeID) throws Exception {
        AttendanceType attendanceType = attendanceTypeService.findById(typeID);
        Attendance attendance = Attendance.builder()
                .type(attendanceType)
                .day(LocalDate.now())
                .time(LocalTime.now())
                .user(sessionInfo.getUser())
                .build();
        return attendenceRepo.save(attendance);
    }

    public Attendance updateLeave(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        Attendance attendance = attendenceRepo.findAttendencesByUserIdAndDay(user.getId(), LocalDate.now());
//        attendance.setLeaveTime(LocalTime.now());
        return attendenceRepo.save(attendance);
    }

    public Set<LocalDate> attendenceUser(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return  attendenceRepo.findAttendencesByUserId(user.getId());
    }
}
