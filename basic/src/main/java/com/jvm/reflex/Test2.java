package com.jvm.reflex;

import java.lang.reflect.Method;

/**
 * @author yeyulin
 * @description:
 * @date 2019/10/29 10:28
 * @since 2.0.7
 **/
public class Test2 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jvm.reflex.Test2");
        Method method = klass.getMethod("target", int.class);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, 128);
        }
    }
}
