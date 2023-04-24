package com.example.Back.services;

import com.example.Back.entity.RequestType;
import com.example.Back.repository.RequestTypesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RequestTypeServices {
    @Autowired
    RequestTypesRepo requestTypesRepo;
    public RequestType save(RequestType requestType){
        return requestTypesRepo.save(requestType);
    }

    public RequestType findById(Long id){
        return requestTypesRepo.findById(id).get();
    }
    public List<RequestType> allTypes(){
        return requestTypesRepo.findAll();
    }
}
