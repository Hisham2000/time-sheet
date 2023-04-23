package com.example.Back.config;

import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import com.example.Back.services.RolesServices;
import com.example.Back.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {

    @Autowired
    UserServices userServices;
    @Autowired
    RolesServices rolesServices;

    @Override
    public void run(String... args) throws Exception {
        rolesServices.save(new Roles(1L,"Admin"));
        rolesServices.save(new Roles(2L,"User"));

        Set<Roles> adminRolesSet = new HashSet<>();
        adminRolesSet.add(rolesServices.findByName("Admin").get());
        Set<Roles> userRolesSet = new HashSet<>();
        userRolesSet.add(rolesServices.findByName("User").get());

        userServices.save(new User(1L,
                "Hisham Anwar",
                "hishamanwar72@gmail.com",
                "01149027532",
                "123456789",
                adminRolesSet
                ));

        userServices.save(new User(2L,
                "AnwarFarouk",
                "Anwar@gmail.com",
                "01149027532",
                "123456789",
                userRolesSet
                ));
    }
}
