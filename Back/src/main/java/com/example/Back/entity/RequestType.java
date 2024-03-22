package com.example.Back.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request_type")
public class RequestType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_type_seq")
    @SequenceGenerator(name = "request_type_seq", initialValue = 1, sequenceName = "request_type_seq", allocationSize = 1)
    private Long id;

    private String name;
}
