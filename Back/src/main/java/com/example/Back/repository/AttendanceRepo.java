package com.example.Back.repository;

import com.example.Back.entity.Attendance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
        public List<Attendance> findByUserIdAndDayOrderByDayDescTimeDesc(Long userId, Date day);

    @Query("SELECT a.day FROM Attendance a where a.user.id = :user_id")
    public Set<LocalDate> findAttendencesByUserId(Long user_id);
}
