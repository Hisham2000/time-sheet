package com.example.Back.secuirty;

import com.example.Back.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    JwtTokenUtilies jwtTokenUtilies;

    @Autowired
    UserUtilis userUtilis;
    @Autowired
    SessionInfo sessionInfo;
    @Autowired
    UserRepo userRepo;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization");
        String token = null;
        String bearer = "Bearer ";
        String email = null;
        if(requestHeader != null && requestHeader.startsWith(bearer)) {
            token = requestHeader.substring(bearer.length());
            email = jwtTokenUtilies.getEmailFromToken(token);

        } else {
            System.out.println("......");
        }

        //check tokenvalidation
        //4- validate token
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {


            UserDetails userDetails = userUtilis.loadUserByUsername(email);

            // if token is valid configure Spring Security to manually set
            // authentication
            if(jwtTokenUtilies.validateToken(token, userDetails.getUsername())) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                sessionInfo.setUser(userRepo.findUsersByEmail(email).get());
            }

        }

        filterChain.doFilter(request, response);

    }
}
