package com.example.Back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "attendance_type")
public class AttendanceType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_type_seq")
    @SequenceGenerator(name = "attendance_type_seq", initialValue = 1, sequenceName = "attendance_type_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "The Name Field Is Required")
    @Column(unique = true)
    private String name;
}
