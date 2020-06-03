package com.stategy;

/**
 * @author yeyulin
 * @description:
 * @date 2020/6/3 9:35
 **/
public class CarTravel implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("car");
    }
}
