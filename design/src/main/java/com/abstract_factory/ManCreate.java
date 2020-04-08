package com.abstract_factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/2 12:14
 * @since palm.1.2.0
 **/
public class ManCreate extends AbstractCreate {
    @Override
    public AbstractProductA createProductA(String type) {
        return value.get(type);
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
