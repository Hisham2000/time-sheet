package com.example.Back.services;

import com.example.Back.entity.Requests;
import com.example.Back.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServices {

    @Autowired
    RequestRepo requestRepo;

    public Requests save(Requests requests){
        return requestRepo.save(requests);
    }

}

