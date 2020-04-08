package com.uml;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/17 15:04
 * @since 2.2
 **/
public class Bus extends Car implements Cars{
    @Override
    protected String name() {
        return "bus";
    }

    @Override
    public Double price() {
        return 12d;
    }
}
