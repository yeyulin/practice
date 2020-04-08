package com.lock;

import com.util.GenericsUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/3 9:56
 * @since 2.0.7
 **/
public class Test<T> {
    public static void main(String[] args) {
        Test test=new Test<Result>(){};
        Class superClassGenricType = GenericsUtils.getSuperClassGenricType(test.getClass());
        System.out.println(superClassGenricType.getCanonicalName());
        List list=new ArrayList();
        list.stream().collect(Collectors.toSet());
        Class class1 = test.getClass1();
        System.out.println(class1.getName());
    }

   private Class<T> getClass1(){
       return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
   }
}
