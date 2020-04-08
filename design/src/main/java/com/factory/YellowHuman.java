package com.factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 12:23
 * @since palm.1.2.0
 **/
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("yellow");
    }

    @Override
    public void talk() {
        System.out.println("yellow talk");
    }

    @Override
    public String getName() {
        return "yellow";
    }
}
