package com.abstract_factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/2 12:13
 * @since palm.1.2.0
 **/
public class PersonCreate extends AbstractCreate {


    @Override
    public AbstractProductA createProductA(String type) {
        return null;
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
