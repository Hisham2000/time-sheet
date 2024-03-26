package com.example.Back.controller;

import com.example.Back.dto.AddNewEmployeeRequest;
import com.example.Back.dto.AuthenticationResponse;
import com.example.Back.dto.LoginRequest;
import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import com.example.Back.handler.PreventSaveException;
import com.example.Back.handler.WrongUserNameOrPasswordException;
import com.example.Back.secuirty.JwtTokenUtilities;
import com.example.Back.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
@CrossOrigin()
public class AuthController {
    @Autowired
    JwtTokenUtilities jwtTokenUtilities;
    @Autowired
    UserServices userServices;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public AuthenticationResponse generateToken(@Validated @RequestBody LoginRequest loginRequest) throws WrongUserNameOrPasswordException {
        Authentication Authentication = null;
        try {
            Authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new WrongUserNameOrPasswordException("Invalid email or password");
        }
        User user = userServices.findUserByEmail(loginRequest.getEmail()).orElseThrow(() -> new WrongUserNameOrPasswordException("There Is No User With This Data"));

        String token = jwtTokenUtilities.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .user(user)
                .build();

    }

    @Secured("HR")
    @PostMapping("/register")
    public ResponseEntity register(@Validated @RequestBody AddNewEmployeeRequest addNewEmployeeRequest) throws PreventSaveException {
        String password = bCryptPasswordEncoder.encode("123456789");
        return ResponseEntity.ok(userServices.save(addNewEmployeeRequest, password));
    }

    //     Note that it isn't necessary to add the ROLE_ prefix here because Spring Security will add that prefix automatically.
//     @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUsername")
    public String  getInfoFromToken(@RequestHeader HashMap headers) {

        String auth = (String) headers.get("authorization");
        return jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
    }


    @GetMapping("/gettokendate")
    public Date getDateFromToken(@RequestHeader HashMap headers) {
        String auth = (String) headers.get("authorization");
        return jwtTokenUtilities.getExpirationDateFromToken(auth.substring("Bearer ".length()));
    }

    @GetMapping("/userroles")
    public Roles getRolesFromToken(@RequestHeader HashMap headers){
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return user.getRole();
    }
}
