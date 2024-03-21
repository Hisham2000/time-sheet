package com.example.Back.config;

import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import com.example.Back.services.RolesServices;
import com.example.Back.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Order(1)
public class StartUp implements CommandLineRunner {

    @Autowired
    UserServices userServices;
    @Autowired
    RolesServices rolesServices;

    @Override
    public void run(String... args) throws Exception {
//        rolesServices.save(new Roles(1L,"User"));
//        rolesServices.save(new Roles(2L,"HR"));
//        rolesServices.save(new Roles(3L,"Manager"));
//
//        Set<Roles> userRolesSet = new HashSet<>();
//        userRolesSet.add(rolesServices.findByName("User").get());
//        Set<Roles> hrRolesSet = new HashSet<>();
//        hrRolesSet.add(rolesServices.findByName("HR").get());
//        Set<Roles> managerRolesSet = new HashSet<>();
//        managerRolesSet.add(rolesServices.findByName("Manager").get());
//
//        userServices.save(new User(1L,
//                "Hisham Anwar",
//                "hishamanwar72@gmail.com",
//                "01149027532",
//                12345,
//                "123456789",
//                userRolesSet
//                ));
//
//        userServices.save(new User(2L,
//                "AnwarFarouk",
//                "Anwar@gmail.com",
//                "01149027532",
//                2345,
//                "123456789",
//                hrRolesSet
//                ));
//        userServices.save(new User(3L,
//                "Hassan Hassan",
//                "Hassan@gmail.com",
//                "01149027532",
//                345,
//                "123456789",
//                managerRolesSet
//        ));
    }
}
