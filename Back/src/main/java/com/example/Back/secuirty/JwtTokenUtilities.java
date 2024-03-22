package com.example.Back.secuirty;

import com.example.Back.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import java.util.HashMap;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtilities {

    long TOKEN_VALIDATION = 3600 * 1000; // 1hour
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    public String generateToken(UserDetails userDetails){
        HashMap<String,Object> claims = new HashMap<>();
        return doGenerateToken(userDetails, claims);
    }


    private String doGenerateToken(UserDetails userDetails, HashMap<String, Object> extraClaims) {
        User user = (User) userDetails;

        String token = Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDATION))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
        return token;
    }

    public Boolean isValidateToken(String token, UserDetails userDetails) {
        final String username = getEmailFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private Claims getAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String getEmailFromToken(String token) {
        String userData = extractClaims(token, Claims::getSubject);
        return userData.split(",")[2].split(":")[1].replace("\"", "").trim();
    }

    public Date getExpirationDateFromToken(String token) {
        Claims claims = getAllClaims(token);
        return claims.getExpiration();
    }


    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
