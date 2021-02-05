package com.liuyanqing.power.local.service;

import com.liuyanqing.power.common.User;
import com.liuyanqing.power.local.dao.UserDao;

/**
 * Created by liuyanqing on 2016/10/8.
 */
public class UserService {

    public int queryUserCount() {
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user) {
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
