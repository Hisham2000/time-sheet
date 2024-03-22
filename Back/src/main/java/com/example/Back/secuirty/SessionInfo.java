package com.example.Back.secuirty;

import com.example.Back.entity.User;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
@Component
public class SessionInfo {
    private User user;
}
