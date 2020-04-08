package com.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 12:26
 * @since palm.1.2.0
 **/
public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> t) {
        try {
            T instance = (T) Class.forName(t.getName()).newInstance();

            childs.add(instance.getName());
            return instance;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
