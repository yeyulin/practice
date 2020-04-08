package com.factory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 12:22
 * @since palm.1.2.0
 **/
public abstract class AbstractHumanFactory implements Family {
    public abstract <T extends Human> T createHuman(Class<T> t);

    protected Collection<String>childs=new ArrayList<>();

    @Override
    public String getMother() {
        return "god";
    }

    @Override
    public Collection<String> getChild() {

        return childs;
    }
}
