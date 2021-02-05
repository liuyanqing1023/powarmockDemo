package com.liuyanqing.power.mockstatic.service;

import com.liuyanqing.power.common.User;
import com.liuyanqing.power.mockstatic.dao.UserDao;

/**
 * Created by liuyanqing on 2016/10/8.
 */
public class UserService {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
