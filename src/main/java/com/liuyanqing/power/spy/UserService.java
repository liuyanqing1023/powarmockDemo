package com.liuyanqing.power.spy;

/**
 * Created by liuyanqing on 2016/10/8.
 */
public class UserService {

    public void foo(String arg) {
        log();
    }

    private void log() {
        System.out.println("I am console log.");
    }


    public boolean exist(String username) {
        return checkExist(username);
    }

    private boolean checkExist(String username) {
        throw new UnsupportedOperationException();
    }
}
