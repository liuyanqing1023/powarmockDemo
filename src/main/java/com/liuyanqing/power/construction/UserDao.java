package com.liuyanqing.power.construction;

/**
 * Created by liuyanqing on 2016/10/8.
 */
public class UserDao
{

    private String username;

    private String password;

    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void insert(){
        throw new UnsupportedOperationException();
    }
}
