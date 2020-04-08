package com.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/26 16:06
 * @since 2.0.7
 **/
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> cs = new ExecutorCompletionService(executor);
        cs.submit(() -> 1);
        cs.submit(() -> 2);
        cs.submit(() -> 3);
        AtomicReference<Integer> m = new AtomicReference<>(Integer.MAX_VALUE);
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                Integer r = null;
                try {
                    r = cs.take().get();
                } catch (Exception e) {
                }
                System.out.println("r:"+r);
                m.set(Integer.min(m.get(), r));
            });
        }
        executor.shutdown();
        System.out.println("m:"+m);
    }
}
