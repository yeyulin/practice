package com.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/20 15:44
 * @since 2.0.7
 **/
public class Atomic {

    class WMRange {
        final int upper;
        final int lower;

        WMRange(int upper, int lower) {
            //省略构造函数实现
            this.upper = 1;
            this.lower = 2;
        }
    }

    final AtomicReference<WMRange> rf = new AtomicReference(new WMRange(0, 0));

    // 设置库存上限
    void setUpper(int v) {
        WMRange nr;
        WMRange or;
        do {
             or = rf.get();
            // 检查参数合法性
            if (v < or.lower) {
                throw new IllegalArgumentException();
            }
            nr = new WMRange(v, or.lower);
        } while (rf.compareAndSet(or, nr));
    }

    public static void main(String[] args) {
        Atomic atomic=new Atomic();
        //atomic.setUpper(12);
        System.out.println(true && true);
    }
}
