package com.example.Back.repository;

import com.example.Back.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendence, Long> {
}
