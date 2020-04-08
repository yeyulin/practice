package com.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/28 10:01
 * @since 2.0.7
 **/
public class BaseAtom {
    public static void main(String[] args) throws InterruptedException {
//        int i = 10;
//        System.out.println(i);
//        i++;
//        StringBuilder builder=new StringBuilder(40);
//        Long a=null;
//
//        String string = builder.append(a).append(a).toString();
//        System.out.println(string);


        List list=new ArrayList();
        list.stream().collect(Collectors.toSet());
        Thread t=new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       // Thread.sleep(100);
        t.start();
        System.out.println(t.isInterrupted());

        t.interrupt();
        System.out.println(t.isInterrupted());
       // Thread.sleep(100);
        System.out.println(t.isInterrupted());
    }

}
