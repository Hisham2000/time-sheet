package com.example.Back.dto;

import com.example.Back.entity.User;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
    private User user;
}

