package com.abstract_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/2 12:11
 * @since palm.1.2.0
 **/
public abstract class AbstractCreate {
    protected static Map<String,AbstractProductA>value=new HashMap();
    static {
        value.put("A1",new ProductA1() );
        value.put("A2",new ProductA2()  );
    }
    public abstract AbstractProductA createProductA(String type);
    public abstract AbstractProductB createProductB();



}
