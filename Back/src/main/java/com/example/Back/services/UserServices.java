package com.example.Back.services;

import com.example.Back.config.SendEmailService;
import com.example.Back.dto.AddNewEmployeeRequest;
import com.example.Back.entity.Roles;
import com.example.Back.entity.User;
import com.example.Back.handler.PreventSaveException;
import com.example.Back.handler.WrongUserNameOrPasswordException;
import com.example.Back.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepo userRepo;

    @Autowired
    SendEmailService sendEmailService;

    @Autowired
    private RolesServices rolesServices;
    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findUserByName(String email){
        return userRepo.findUsersByEmail(email);
    }

    public User save(AddNewEmployeeRequest addNewEmployeeRequest, String password) throws PreventSaveException {
        Roles role = rolesServices.findById(addNewEmployeeRequest.getRoleId());
        User user = User.builder()
                .role(role)
                .phone(addNewEmployeeRequest.getPhone())
                .name(addNewEmployeeRequest.getName())
                .email(addNewEmployeeRequest.getEmail())
                .salary(addNewEmployeeRequest.getSalary())
                .password(password)
                .build();

        return userRepo.save(user);
//        String body = "User Name: " + user.getName() + "\n Email: "+ user.getEmail() + "\n password: 123456789";
//        sendEmailService.sendEmail(user.getEmail(),
//                "Account Details on Time Sheet", body);
//        userRepo.save(user);
    }

    public User findByEmail(String email){
        return userRepo.findUsersByEmail(email).get();
    }

    public User findById(Long id){
        return userRepo.findById(id).get();
    }

    public Iterable<User> delete(Long id){
        userRepo.deleteById(id);
        return userRepo.findAll();
    }

    public Optional<User> findUserByEmail(String email) throws WrongUserNameOrPasswordException {
        return userRepo.findByEmail(email);
    }

}
