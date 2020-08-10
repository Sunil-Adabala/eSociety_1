package com.sunil.esociety_1.service;

import com.sunil.esociety_1.model.Users;

public interface UserService {
    public void saveUser(Users user);

    public boolean isUserAlreadyPresent(Users user);
}
