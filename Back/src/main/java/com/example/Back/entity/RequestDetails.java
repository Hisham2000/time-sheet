package com.example.Back.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request_details")
public class RequestDetails {

    public RequestDetails(LocalDate fromDay, LocalDate toDay, int halfDayOrFullDay, VacationType vacationType, Requests request, String desription, int status){
        this.fromDay = fromDay;
        this.toDay = toDay;
        this.halfDayOrFullDay = halfDayOrFullDay;
        this.vacationType = vacationType;
        this.requests = request;
        this.desription = desription;
        this.status = status;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_details_seq")
    @SequenceGenerator(name = "request_details_seq", initialValue = 1, sequenceName = "request_details_seq", allocationSize = 1)
    private Long id;

    private LocalDate fromDay;
    private LocalDate toDay;
    private String desription;

    // zero for not set in request 1 for halfday 2 for full day
    private int halfDayOrFullDay;

    // zero for pending 1 for accepted 2 for rejected
    private int status = 0;
    @ManyToOne
    private VacationType vacationType;
    @OneToOne(cascade = CascadeType.ALL)
    private Requests requests;





}
