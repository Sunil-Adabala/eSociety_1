package com.sunil.esociety_1;


import com.sunil.esociety_1.model.AuthRole;
import com.sunil.esociety_1.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {

    private Users users;

    public UserPrincipal(Users user) {
        super();
        this.users = user;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("USER"));
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<AuthRole> roles = users.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (AuthRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return authorities;
    }


    @Override
    public String getPassword() {
//        System.out.println(getPassword());
        return users.getPassword();
    }

    @Override
    public String getUsername() {
//        System.out.println(getUsername());
        return users.getUsername();
    }




    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "UserPrincipal{" +
                "user=" + users +
                '}';
    }
}
