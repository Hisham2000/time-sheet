package com.example.Back.config;

import com.example.Back.entity.RequestType;
import com.example.Back.services.RequestTypeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(2)
public class RequestTypesRunner implements CommandLineRunner {

    @Autowired
    RequestTypeServices requestTypeServices;
    @Override
    public void run(String... args) throws Exception {
//        RequestType requestType = new RequestType(1L, "Work From Home");
//        requestTypeServices.save(requestType);
//        requestType = new RequestType(2L, "Vacation request");
//        requestTypeServices.save(requestType);
//        requestType = new RequestType(3L, "Permission");
//        requestTypeServices.save(requestType);
//        requestType = new RequestType(4L, "Work Leave");
//        requestTypeServices.save(requestType);
    }
}
