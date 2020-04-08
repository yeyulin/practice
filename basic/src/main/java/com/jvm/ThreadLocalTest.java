package com.jvm;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/11 9:41
 * @since 2.0.7
 **/
public class ThreadLocalTest {
    ThreadLocal<Double>threadLocal=new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test=new ThreadLocalTest();
        test.setValue();
        System.gc();
        Thread.sleep(100);
        System.out.println(test.getValue());
    }
    public void setValue(){
        threadLocal.set(12.0);
    }
    public Double getValue(){
        return threadLocal.get();
    }
}
