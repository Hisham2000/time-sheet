package com.example.Back.dto;

import com.example.Back.annotation.EntityExists;
import com.example.Back.entity.User;
import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotNull(message = "The Email Field Is Required")
    @EntityExists(message = "There Is An Error In Email Or Password",
    propertyName = "email",
    entityClass = User.class)
    private String email;
    @NotNull(message = "The Password Field IS Required")
    private String password;
}
