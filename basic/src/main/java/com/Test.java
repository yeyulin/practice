package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/2 10:01
 * @since 2.0.7
 **/
public class Test {
    final char[] hb;

    public Test(char[] value) {
        hb = value;
    }

    public char[] getHb() {
        return hb;
    }

    public static void main(String[] args) {
        char[] hb={'a','c'};
        Test test=new Test(hb);
        char[] hb1 = test.getHb();
        hb1[0]='c';
        Test test1=new Test(hb1);
        System.out.println(test1.getHb());
        System.out.println(test.getHb());
        Lock lock=new ReentrantLock();
        lock.tryLock();
  }
}
