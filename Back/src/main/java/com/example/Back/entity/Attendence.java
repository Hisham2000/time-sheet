package com.example.Back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendence {

    public Attendence(Date day, LocalTime enterTime, LocalTime leaveTime, User user){
        this.day = day;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date day;
    private LocalTime enterTime;
    private LocalTime leaveTime;
    @ManyToOne
    private User user;

}
