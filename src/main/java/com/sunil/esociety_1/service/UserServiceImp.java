package com.sunil.esociety_1.service;

import com.sunil.esociety_1.dao.AuthRoleDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.model.AuthRole;
import com.sunil.esociety_1.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    AuthRoleDao authRoleDao;

    @Autowired
    UsersDao usersDao;

    @Override
    public void saveUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        AuthRole userRole = authRoleDao.findByRole("SITE_USER");
        user.setRoles(new HashSet<AuthRole>(Arrays.asList(userRole)));
        usersDao.save(user);
    }

    @Override
    public boolean isUserAlreadyPresent(Users user) {
        return false;
    }
}
