package com.example.Back.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacation_type")
public class VacationType {
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacation_type_seq")
    @SequenceGenerator(name = "vacation_type_seq", initialValue = 1, sequenceName = "vacation_type_seq", allocationSize = 1)
    private Long id;
    private String name;

}
