package com.example.Back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "requests")
@AllArgsConstructor
@NoArgsConstructor
public class Requests {
    public Requests(RequestType requestType, User user){
        this.requestType = requestType;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requests_seq")
    @SequenceGenerator(name = "requests_seq", initialValue = 1, sequenceName = "requests_seq", allocationSize = 1)
    private Long id;



    @ManyToOne
    private RequestType requestType;
    @ManyToOne
    private User user;

}
