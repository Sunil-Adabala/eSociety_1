//package com.sunil.esociety_1;
//
//
//import com.sunil.esociety_1.dao.UsersDao;
//import com.sunil.esociety_1.model.AuthRole;
//import com.sunil.esociety_1.model.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UsersDao usersDao;
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////        System.out.println(usersDao.findByUsername(username));
////
////        Users user = usersDao.getUserByUsername(username);
//////        System.out.println(user);
////        if(user == null)
////        {
////            System.out.println("here");
////            throw new UsernameNotFoundException("User 404");
////        }
////
////        return new UserPrincipal(user);
////    }
//}
//
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        Set<AuthRole> roles = users.getRoles();
////        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
////
////        for (AuthRole role : roles) {
////            authorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
////
////        return authorities;
////    }
