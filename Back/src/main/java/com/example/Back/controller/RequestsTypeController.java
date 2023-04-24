package com.example.Back.controller;

import com.example.Back.entity.RequestType;
import com.example.Back.services.RequestTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestsTypeController {
    @Autowired
    RequestTypeServices requestTypeServices;
    @GetMapping("/types")
    public List<RequestType> allTypes(){
        return requestTypeServices.allTypes();
    }
}
