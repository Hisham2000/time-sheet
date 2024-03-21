package com.example.Back.repository;

import com.example.Back.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendance, Long> {
    public Attendance findAttendencesByUserIdAndDay(Long user_id, LocalDate day);

    @Query("SELECT a.day FROM Attendance a where a.user.id = :user_id")
    public Set<LocalDate> findAttendencesByUserId(Long user_id);
}
