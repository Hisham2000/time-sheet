package com.example.Back.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance")
public class Attendance {

    public Attendance(LocalDate day, LocalTime enterTime, LocalTime leaveTime, User user){
        this.day = day;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_seq")
    @SequenceGenerator(name = "attendance_seq", initialValue = 1, sequenceName = "attendance_seq", allocationSize = 1)
    private Long id;

    private LocalDate day;
    private LocalTime enterTime;
    private LocalTime leaveTime;
    @ManyToOne
    private User user;

}
