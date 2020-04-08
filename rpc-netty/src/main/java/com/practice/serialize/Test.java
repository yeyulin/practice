package com.practice.serialize;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/7 13:42
 * @since 2.0.7
 **/
public class Test {
    public static void main(String[] args) {
        String souce = "123";
        byte[] serialize = SerializeSupport.serialize(souce);
        System.out.println(serialize);
        Object parse = SerializeSupport.parse(serialize);
        System.out.println(parse);
    }
}
