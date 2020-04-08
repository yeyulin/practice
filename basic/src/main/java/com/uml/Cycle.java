package com.uml;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/17 15:06
 * @since 2.2
 **/
public class Cycle extends Car implements Cars{
    @Override
    protected String name() {
        return "Cycle";
    }

    @Override
    public Double price() {
        return 1d;
    }
}
