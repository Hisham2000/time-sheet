package com.example.Back.services;

import com.example.Back.entity.AttendanceType;
import com.example.Back.repository.AttendanceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceTypeService {
    @Autowired
    private AttendanceTypeRepo attendanceTypeRepo;

    public AttendanceType findById(Long id) throws Exception {
        return attendanceTypeRepo.findById(id).orElseThrow(()-> new Exception("There Is No Attendance Type With This Id"));
    }

    public List<AttendanceType> findAll(){
        return attendanceTypeRepo.findAll();
    }
}
