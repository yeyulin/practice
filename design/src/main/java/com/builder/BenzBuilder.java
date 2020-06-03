package com.builder;

import java.util.ArrayList;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/8 12:08
 **/
public class BenzBuilder extends CarBuilder{
    private BenzModel benzModel=new BenzModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {

    }

    @Override
    public CarModel getCarModel() {
        return benzModel;
    }
}
