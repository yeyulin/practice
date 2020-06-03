package com.stategy;

/**
 * @author yeyulin
 * @description:
 * @date 2020/6/3 14:14
 **/
public class Test {
    public static void main(String[] args) {
        String name="12";
        TravelStrategy travelStrategy=new CarTravel();
        Context context=new Context();
        context.setTravelStrategy(travelStrategy);
        context.travel();

    }
}
