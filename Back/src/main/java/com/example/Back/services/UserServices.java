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
import org.thymeleaf.context.Context;

import javax.management.relation.Role;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepo userRepo;

    @Autowired
    EmailService emailService;

    @Autowired
    private RolesServices rolesServices;
    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findUserByName(String email){
        return userRepo.findUsersByEmail(email);
    }

    public User save(AddNewEmployeeRequest addNewEmployeeRequest, String password) throws Exception {
        Roles role = rolesServices.findById(addNewEmployeeRequest.getRoleId());
        User user = User.builder()
                .role(role)
                .phone(addNewEmployeeRequest.getPhone())
                .name(addNewEmployeeRequest.getName())
                .email(addNewEmployeeRequest.getEmail())
                .salary(addNewEmployeeRequest.getSalary())
                .password(password)
                .build();
        Context context = new Context();
        Map<String, Object> model = new HashMap<>();
        model.put("password", "123456789");
        model.put("toMail", user.getEmail());
        model.put("userName", user.getName());
        model.put("password", "123456789");
        model.put("supportMail", "sales@mint-ops.com");

        emailService.processEmailTemplateAndSend(model, context, user.getEmail(), "Welcome Email", "welcome.html");
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
