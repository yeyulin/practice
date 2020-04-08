package com.arithmetic.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yeyulin
 * @description: 数据流中的移动平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * @date 2019/12/4 21:39
 * @since 2.0.7
 * 思路：
 * 队列queue，用一个queue记录进入窗口的整数。当流进窗口的整数不足时，
 * 计算所有窗口内的数字和返回，当进入窗口的整数多于窗口大小时，
 * 移除最先进入窗口的整数，新的整数进入queue，然后计算窗口内的整数和
 **/
public class MovingAverage {
    private int maxSize;
    private Queue<Integer> windows;
    private double previousSum = 0.0;

    public MovingAverage(int maxSize) {
        this.maxSize = maxSize;
        this.windows = new LinkedList<>();
    }

    public double next(int val) {
        //判断大小
        if (maxSize == windows.size()) {
            previousSum = previousSum - windows.remove();
        }
        windows.add(val);
        previousSum += val;
        return previousSum / windows.size();
    }

    public Queue<Integer> getWindows() {
        return windows;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        double next = m.next(1);
        System.out.println(m.getWindows());
        System.out.println(m.next(10));
        System.out.println(m.getWindows());
        System.out.println(m.next(3));
        System.out.println(m.getWindows());
        System.out.println(m.next(5));
        System.out.println(m.getWindows());

    }

}
