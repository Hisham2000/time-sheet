package com.example.Back.secuirty;

import io.jsonwebtoken.Claims;
import java.util.HashMap;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtilies {

    long TOKEN_VALIDATION = 3600 * 1000; // 1hour
    String SECRET_KEY = "Hisham Anwar";

    public String generateToken(String email){
        HashMap<String,Object> claims = new HashMap<>();
        return doGenerateToken(email, claims);
    }

    private String doGenerateToken(String username, HashMap<String, Object> claims) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDATION))
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }






    public Boolean validateToken(String token, String subject) {
        final String username = getEmailFromToken(token);
        return (username.equals(subject) && !isTokenExpired(token));

    }

    private Claims getAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String getEmailFromToken(String token) {
        Claims claims = getAllClaims(token);
        return claims.getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        Claims claims = getAllClaims(token);
        return claims.getExpiration();
    }


    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
}
