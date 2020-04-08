package com.factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 12:23
 * @since palm.1.2.0
 **/
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void talk() {
        System.out.println("black talk");
    }

    @Override
    public String getName() {
        return "black";
    }
}
