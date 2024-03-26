package com.example.Back.dto;

import com.example.Back.annotation.EntityExists;
import com.example.Back.entity.Roles;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class AddNewEmployeeRequest {

    @NotNull(message = "The Employee Name Is Required")
    private String name;

    @NotNull(message = "The Employee Email Is Required")
    private String email;

    @NotNull(message = "The Role Id Is Required")
    @EntityExists(message = "There Is No Role With This Id",
    entityClass = Roles.class,
    propertyName = "id")
    private Long roleId;

    @NotNull(message = "The Salary Field Is Required")
    private Integer salary;

    @NotNull(message = "The Phone Required")
    private String phone;

}
