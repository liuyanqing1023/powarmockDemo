package com.liuyanqing.power;

import java.util.Optional;

/**
 * Created by PC-CWB on 2017/4/16.
 */

public class Person {

    private Car car;

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }
}
