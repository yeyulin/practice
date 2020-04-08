package com.lock.limmit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/13 11:22
 * @since 2.0.7
 **/
public class CustomerLimmit {
    private CustomerLimmit() {
    }

    private static CustomerLimmit single = new CustomerLimmit();
    private static AtomicInteger count = new AtomicInteger(0);
    private static final int MAX = 1000;
    private static final long interval = 60_000;
    private volatile long timeStamp = getNowTime();

    private boolean require() {
        long now = getNowTime();
        //当时间超出一秒，重新赋值
        while (now > timeStamp + interval) {
            timeStamp = now;
            count.set(0);
        }
        //时间再一秒内，判断线程数量
        return count.getAndIncrement() < MAX;
    }

    public static CustomerLimmit getInstance() {
        return single;
    }

    private Long getNowTime() {
        return System.currentTimeMillis();
    }

}
