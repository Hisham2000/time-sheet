package com.example.Back.repository;

import com.example.Back.entity.AttendanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceTypeRepo extends JpaRepository<AttendanceType, Long> {
}
