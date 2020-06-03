package com.stategy;

/**
 * @author yeyulin
 * @description:
 * @date 2020/6/3 14:13
 **/
public class Context {
    private TravelStrategy travelStrategy;

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travel() {
        this.travelStrategy.travel();
    }
}
