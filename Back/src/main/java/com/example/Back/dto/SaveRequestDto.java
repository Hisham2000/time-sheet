package com.example.Back.dto;

import com.example.Back.entity.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveRequestDto {
    private Date fromDate;
    private Date toDate;

    private RequestType requestType;

}
