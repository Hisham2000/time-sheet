package com.example.Back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", initialValue = 1, sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "The Name Field Is Required")
    private String name;

    @NotNull(message = "The Email Is Required")
    @Column(unique = true)
    private String email;

    @NotNull(message = "The Phone Filed Is Required")
    private String phone;

    @NotNull(message = "The Salary Field Is Required")
    private Integer salary;

    @NotNull(message = "The Password Field Is Required")
    @JsonIgnore
    private String password;

    @NotNull(message = "The Role Is Required")
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles role;

    @Override
    public String toString() {
        String userData = "{" +
                "\"id\": " + id +
                ", \"name\": \"" + name + "\"" +
                ", \"email\": \"" + email + "\"" +
                ", \"role\" : \"" + role.getName() + "\"" +
                "}";
        return userData;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

}
