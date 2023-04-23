package com.example.Back.secuirty;

import lombok.Data;

@Data
public class JwtTokenRequest {
    private String email;
    private String password;
}
