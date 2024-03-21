package com.example.Back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", initialValue = 1, sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private int salary;
    @JsonIgnore
    private String password;
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles role;

    @Override
    public String toString() {
        String userData = "{" +
                "\"id\": " + id +
                ", \"name\": \"" + name + "\"" +
                ", \"email\": \"" + email + "\"" +
                ", \"role\" : \"" + role.getName() + "\"" +
                "}";
        return userData;
    }
}
