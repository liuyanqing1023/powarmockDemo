package com.liuyanqing.power.construction;

import com.liuyanqing.power.local.dao.*;

/**
 * Created by liuyanqing on 2016/10/8.
 */
public class UserService
{
    public void save(String username,String password){
        UserDao userDao = new UserDao(username,password);
        userDao.insert();
    }
}
