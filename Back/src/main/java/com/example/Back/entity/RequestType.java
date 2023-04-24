package com.example.Back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "req_type_seq")
    @SequenceGenerator(name = "req_type_seq", initialValue = 1, sequenceName = "req_type_seq", allocationSize = 1)
    private Long id;

    private String name;
}
