package com.abstract_factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/2 12:09
 * @since palm.1.2.0
 **/
public abstract class AbstractProductA {
    public void shareMethod(){
        System.out.println("AbstractProductA");
    }
    public abstract void doSomething();
}
