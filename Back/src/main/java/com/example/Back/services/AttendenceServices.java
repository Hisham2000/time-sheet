package com.example.Back.services;

import com.example.Back.entity.Attendance;
import com.example.Back.entity.AttendanceType;
import com.example.Back.entity.User;
import com.example.Back.handler.PreventSaveException;
import com.example.Back.repository.AttendanceRepo;
import com.example.Back.secuirty.JwtTokenUtilities;
import com.example.Back.secuirty.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class AttendenceServices {
    @Autowired
    AttendanceRepo attendanceRepo;

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
        Attendance lastAttendanceToday = getTheLastTodayAttendance();
        if(lastAttendanceToday == null && attendanceType.getName().equals("Sign Out")){
            throw new PreventSaveException("You Have To Sign In First");
        }else if(lastAttendanceToday != null && lastAttendanceToday.getType().getName().equals(attendanceType.getName())){
            throw new PreventSaveException("You Did This Action Before");
        }
        Attendance attendance = Attendance.builder()
                .type(attendanceType)
                .day(new Date())
                .time(new Date())
                .user(sessionInfo.getUser())
                .build();
        return attendanceRepo.save(attendance);
    }

    public Attendance getTheLastTodayAttendance() throws ParseException {
        Date day = new Date();
        List<Attendance> attendanceList = attendanceRepo.findByUserIdAndDayOrderByDayDescTimeDesc(sessionInfo.getUser().getId(), day);
        if(attendanceList != null && attendanceList.size() > 0){
            return attendanceList.get(0);
        }
        return null;
    }

    public Attendance updateLeave(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
//        Attendance attendance = attendanceRepo.findAttendanceByUserIdAndDay(user.getId(), LocalDate.now());
//        attendance.setLeaveTime(LocalTime.now());
        return null;
    }

    public Set<LocalDate> attendenceUser(HashMap headers) {
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return  attendanceRepo.findAttendencesByUserId(user.getId());
    }
}
