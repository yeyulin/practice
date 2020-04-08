package com.factory;

import java.util.Collection;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 12:29
 * @since palm.1.2.0
 **/
public class Test {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        humanFactory.createHuman(YellowHuman.class);

        humanFactory.createHuman(WhiteHuman.class);

        humanFactory.createHuman(BlackHuman.class);
        String mother = humanFactory.getMother();
        System.out.println(mother);
        Collection<String> child = humanFactory.getChild();
        System.out.println(child);


    }
}
