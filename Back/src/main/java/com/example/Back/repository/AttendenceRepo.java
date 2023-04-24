package com.example.Back.repository;

import com.example.Back.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendence, Long> {
    public Attendence findAttendencesByUserIdAndDay(Long user_id, LocalDate day);

    @Query("SELECT a.day FROM Attendence a where a.user.id = :user_id")
    public Set<LocalDate> findAttendencesByUserId(Long user_id);
}
