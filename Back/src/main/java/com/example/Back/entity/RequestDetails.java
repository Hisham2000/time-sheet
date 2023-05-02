package com.example.Back.entity;

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
public class RequestDetails {

    public RequestDetails(LocalDate fromDay, LocalDate toDay, int halfDayOrFullDay, VaccationType vaccationType, Requests request, String desription, int status){
        this.fromDay = fromDay;
        this.toDay = toDay;
        this.halfDayOrFullDay = halfDayOrFullDay;
        this.vaccationType = vaccationType;
        this.requests = request;
        this.desription = desription;
        this.status = status;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "req_detail_seq")
    @SequenceGenerator(name = "req_detail_seq", initialValue = 1, sequenceName = "req_detail_seq", allocationSize = 1)
    private Long id;

    private LocalDate fromDay;
    private LocalDate toDay;
    private String desription;

    // zero for not set in request 1 for halfday 2 for full day
    private int halfDayOrFullDay;

    // zero for pending 1 for accepted 2 for rejected
    private int status = 0;
    @ManyToOne
    private VaccationType vaccationType;
    @OneToOne(cascade = CascadeType.ALL)
    private Requests requests;





}
