package com.DeaJayaNet.service;

import com.DeaJayaNet.dao.user.UserDao;
import com.DeaJayaNet.model.user.User;

public class AuthService {
    private UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
