//package com.example.Back.config;
//
//import com.example.Back.entity.Requests;
//import com.example.Back.services.RequestServices;
//import com.example.Back.services.RequestTypeServices;
//import com.example.Back.services.UserServices;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//@RequiredArgsConstructor
//@Order(3)
//public class RequestRunner implements CommandLineRunner {
//    @Autowired
//    RequestServices requestServices;
//    @Autowired
//    UserServices userServices;
//    @Autowired
//    RequestTypeServices requestTypeServices;
//    @Override
//    public void run(String... args) throws Exception {
//        Requests requests = new Requests(1L, new Date(), new Date(), requestTypeServices.findById(1L), userServices.findById(1L));
//        requestServices.save(requests);
//    }
//}
