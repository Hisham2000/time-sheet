package com.example.Back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requests {
    public Requests(RequestType requestType, User user){
        this.requestType = requestType;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "req_seq")
    @SequenceGenerator(name = "req_seq", initialValue = 1, sequenceName = "req_seq", allocationSize = 1)
    private Long id;



    @ManyToOne
    private RequestType requestType;
    @ManyToOne
    private User user;

}
