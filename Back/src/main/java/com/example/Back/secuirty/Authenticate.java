package com.example.Back.secuirty;

import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import com.example.Back.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class Authenticate {
    @Autowired
    JwtTokenUtilies jwtTokenUtilies;
    @Autowired
    UserServices userServices;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String generateToken(@RequestBody JwtTokenRequest jwtTokenRequest) {

        //if authentication is success it will proceed to generate token
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtTokenRequest.getEmail(), jwtTokenRequest.getPassword())
        );
        return jwtTokenUtilies.generateToken(jwtTokenRequest.getEmail());
    }

    @Secured("HR")
    @PostMapping("/register")
    public void register(@RequestBody User user){
        userServices.save(user);
    }

    //     Note that it isn't necessary to add the ROLE_ prefix here because Spring Security will add that prefix automatically.
//     @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUsername")
    public String  getInfoFromToken(@RequestHeader HashMap headers) {

        String auth = (String) headers.get("authorization");
        return jwtTokenUtilies.getEmailFromToken(auth.substring("Bearer ".length()));
    }


    @GetMapping("/gettokendate")
    public Date getDateFromToken(@RequestHeader HashMap headers) {
        String auth = (String) headers.get("authorization");
        return jwtTokenUtilies.getExpirationDateFromToken(auth.substring("Bearer ".length()));
    }

    @GetMapping("/userroles")
    public Set<Roles> getRolesFromToken(@RequestHeader HashMap headers){
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilies.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return user.getRolesset();
    }
}
