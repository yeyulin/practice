package com.jvm.reflex;

import java.lang.reflect.Method;

/**
 * @author yeyulin
 * @description:
 * @date 2019/10/28 14:42
 * @since 2.0.7
 **/
public class Test1 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }
    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jvm.reflex.Test1");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}
