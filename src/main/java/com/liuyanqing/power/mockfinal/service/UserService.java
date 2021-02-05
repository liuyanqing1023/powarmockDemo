package com.liuyanqing.power.mockfinal.service;

import com.liuyanqing.power.common.User;
import com.liuyanqing.power.mockfinal.dao.UserDao;

/**
 * Created by liuyanqing on 2016/10/8.
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.insertUser(user);
    }
}
