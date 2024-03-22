package com.example.Back.entity;

import jakarta.validation.constraints.NotNull;
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
@Builder
public class Attendance {

    public Attendance(LocalDate day, LocalTime enterTime, LocalTime leaveTime, User user){
        this.day = day;
//        this.enterTime = enterTime;
//        this.leaveTime = leaveTime;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_seq")
    @SequenceGenerator(name = "attendance_seq", initialValue = 1, sequenceName = "attendance_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "The Day Field Is Required")
    private LocalDate day;

    @NotNull(message = "The Time Field Is Required")
    private LocalTime time;

    @ManyToOne()
    @JoinColumn(name = "attendance_type_id")
    @NotNull(message = "The Type Is Required")
    private AttendanceType type;

    @ManyToOne()
    @JoinColumn(name = "user_Id")
    @NotNull(message = "The User Is Required")
    private User user;

}
