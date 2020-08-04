package com.sunil.esociety_1;


import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersDao.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User 404");
        }


        return new UserPrincipal(user);
    }
}
