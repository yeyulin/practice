package com.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/25 14:45
 * @since 2.0.7
 **/
public class FutureTest {

    private static Integer i=0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor   = Executors.newFixedThreadPool(1);
        Future<?> submit = executor.submit(new Task());
        Integer s = (Integer) submit.get();
        System.out.println(s);
    }
   static class Task implements Callable{


       @Override
       public Object call() throws Exception {
           return ++i;
       }
   }
}
