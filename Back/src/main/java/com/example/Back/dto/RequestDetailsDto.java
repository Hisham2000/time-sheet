package com.example.Back.dto;

import com.example.Back.entity.Requests;
import com.example.Back.entity.VacationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDetailsDto {

    private LocalDate fromDay;
    private LocalDate toDay;
    private int halfDayOrFullDay;
    private VacationType vacationType;
    private Requests requests;
    private String description;
    private int status;

}
