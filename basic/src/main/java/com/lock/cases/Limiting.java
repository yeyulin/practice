package com.lock.cases;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/5 14:47
 * @since 2.0.7
 **/
public class Limiting {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(2.0);
        ExecutorService service = Executors.newFixedThreadPool(1);
        Long prev = System.currentTimeMillis() / 1000 % 60;
        for (int i = 0; i < 20; i++) {
            double acquire = limiter.acquire(1);
            System.out.println(acquire);
            service.execute(() -> {
                long cur = System.currentTimeMillis() / 1000 % 60;
                System.out.println(cur - prev);
            });
        }
        service.shutdown();

    }

}
