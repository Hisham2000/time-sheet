package com.example.Back.config;

import com.example.Back.entity.VaccationType;
import com.example.Back.services.VaccationTypeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(4)
public class VaccationTypeRunner implements CommandLineRunner {
    @Autowired
    VaccationTypeServices vaccationTypeServices;
    @Override
    public void run(String... args) throws Exception {
        vaccationTypeServices.save(new VaccationType(1L, "Annual Vacation"));
        vaccationTypeServices.save(new VaccationType(2L, "Casual Vacation"));
        vaccationTypeServices.save(new VaccationType(3L, "UnPaid Leave"));
        vaccationTypeServices.save(new VaccationType(4L, "Sick Leave"));


    }
}
