package com.example.Back.secuirty;

import com.example.Back.handler.WrongUserNameOrPasswordException;
import com.example.Back.repository.UserRepo;
import com.example.Back.services.UserServices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    JwtTokenUtilities jwtTokenUtilities;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    SessionInfo sessionInfo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserServices userService;


    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        final String requestHeader = request.getHeader("Authorization");
        final String token;
        final String bearer = "Bearer ";
        final String email;
        if(requestHeader == null || !requestHeader.startsWith(bearer)){
            filterChain.doFilter(request, response);
            return;
        }
        token = requestHeader.substring(bearer.length());
        email = jwtTokenUtilities.getEmailFromToken(token);
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
            if(jwtTokenUtilities.isValidateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                try {
                    sessionInfo.setUser(userService.findUserByEmail(email).get());
                } catch (WrongUserNameOrPasswordException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}
