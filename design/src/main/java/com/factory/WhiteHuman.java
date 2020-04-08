package com.factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 12:23
 * @since palm.1.2.0
 **/
public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void talk() {
        System.out.println("white talk");
    }

    @Override
    public String getName() {
        return "white";
    }
}
