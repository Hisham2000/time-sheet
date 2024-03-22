package com.example.Back.controller;

import com.example.Back.dto.RequestDetailsDto;
import com.example.Back.entity.RequestDetails;
import com.example.Back.entity.User;
import com.example.Back.secuirty.JwtTokenUtilities;
import com.example.Back.services.RequestDetailsServices;
import com.example.Back.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/requestDetails", consumes = "application/json",produces = "application/json")
@CrossOrigin()
public class RequestDetailsController {
    @Autowired
    JwtTokenUtilities jwtTokenUtilities;
    @Autowired
    UserServices userServices;
    @Autowired
    RequestDetailsServices requestDetailsServices;
    @PostMapping("/save")
    public RequestDetails save(@RequestBody RequestDetailsDto requestDetailsDto, @RequestHeader HashMap headers){
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return requestDetailsServices.save(requestDetailsDto, user);
    }

    @GetMapping("/all")
    public List<RequestDetails> allAccepted(@RequestHeader HashMap headers){
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return requestDetailsServices.allAccepted(user.getId());
    }

    @GetMapping("/pending")
    public List<RequestDetails> allPending(@RequestHeader HashMap headers){
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return requestDetailsServices.allPending(user.getId());
    }

    @GetMapping("/rejected")
    public List<RequestDetails> all(@RequestHeader HashMap headers){
        String auth = (String) headers.get("authorization");
        String email = jwtTokenUtilities.getEmailFromToken(auth.substring("Bearer ".length()));
        User user = userServices.findByEmail(email);
        return requestDetailsServices.allRejected(user.getId());
    }
}
