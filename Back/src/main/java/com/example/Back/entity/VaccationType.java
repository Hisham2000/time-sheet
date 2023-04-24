package com.example.Back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccationType {
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacc_type_seq")
    @SequenceGenerator(name = "vacc_type_seq", initialValue = 1, sequenceName = "vacc_type_seq", allocationSize = 1)
    private Long id;
    private String name;

}
