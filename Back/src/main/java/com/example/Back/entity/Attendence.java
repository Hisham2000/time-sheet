package com.example.Back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendence {

    public Attendence(LocalDate day, LocalTime enterTime, LocalTime leaveTime, User user){
        this.day = day;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "att_seq")
    @SequenceGenerator(name = "att_seq", initialValue = 1, sequenceName = "att_seq", allocationSize = 1)
    private Long id;

    private LocalDate day;
    private LocalTime enterTime;
    private LocalTime leaveTime;
    @ManyToOne
    private User user;

}
