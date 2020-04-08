package com.abstract_factory;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/2 12:15
 * @since palm.1.2.0
 **/
public class Test {
    public static void main(String[] args) {
        AbstractCreate manCreate = new ManCreate();
        AbstractCreate personCreate = new PersonCreate();
        AbstractProductA productA = manCreate.createProductA("A2");
        productA.doSomething();

        AbstractProductA productA1 = manCreate.createProductA("A1");
        productA1.doSomething();
        int tenThousand = 10_000;
        int thousand = 1_000;

        int humand = 100;
        int ten = 10;
        System.out.println(tenThousand | thousand);

    }
}
