package com.arithmetic.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yeyulin
 * @description: 最近的请求次数
 * @date 2019/12/4 22:12
 * @since 2.0.7
 * @since https://leetcode-cn.com/problems/number-of-recent-calls/
 *
 **/
public class RecentCounter {
    private List<Integer>timeList;
    private int minIndex=0;

    public RecentCounter() {
        //插入有序
        this.timeList = new ArrayList<>();
    }
    public Integer ping(int t){
        timeList.add(t);
        for (int i = minIndex; i < timeList.size(); i++) {
            Integer item = timeList.get(i);
            if(t-3000>item){
                minIndex++;
            }else{
                break;
            }
        }
        return timeList.size()-minIndex;
    }

    public static void main(String[] args) {
        RecentCounter recentCounter=new RecentCounter();
        recentCounter.ping(1);
        recentCounter.ping(100);
        System.out.println(recentCounter.ping(3001));
        Integer ping = recentCounter.ping(3002);
        System.out.println(ping);
    }

}
