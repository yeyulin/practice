package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/19 10:22
 * @since 2.0.7
 **/
public class LiveLock2 {

    class Account {
        private int balance;
        private final Lock lock
                = new ReentrantLock();

        // 转账
        void transfer(Account tar, int amt) {
            while (true) {
                if (this.lock.tryLock()) {
                    try {
                        if (tar.lock.tryLock()) {
                            try {
                                this.balance -= amt;
                                tar.balance += amt;
                            } finally {
                                tar.lock.unlock();
                            }
                        }//if
                    } finally {
                        this.lock.unlock();
                    }
                }//if
            }//while
        }//transfer
    }
}
