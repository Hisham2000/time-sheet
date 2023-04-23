package com.example.Back.secuirty;

import com.example.Back.entity.User;
import com.example.Back.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserUtilis implements UserDetailsService {
    @Autowired
    UserServices userServices;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userServices.findUserByName(email);
        if(!user.isPresent())
            throw new UsernameNotFoundException("This User Not Found " + email);

        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), getAuthorities(user.get()));
    }

    private static List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(!user.getRolesset().isEmpty()){
            user.getRolesset().forEach(roles -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(roles.getName()));
            });
        }
        return  grantedAuthorities;
    }
}
