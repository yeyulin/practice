package com.builder;

import java.util.ArrayList;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/8 12:06
 * @since palm.1.2.0
 **/
public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String>sequence);
    public abstract CarModel getCarModel();
}
