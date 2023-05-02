package com.example.Back.dto;

import com.example.Back.entity.RequestType;
import com.example.Back.entity.Requests;
import com.example.Back.entity.VaccationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDetailsDto {

    private LocalDate fromDay;
    private LocalDate toDay;
    private int halfDayOrFullDay;
    private VaccationType vaccationType;
    private Requests requests;
    private String description;
    private int status;

}
