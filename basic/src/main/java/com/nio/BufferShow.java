package com.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author yeyulin
 * @description: buffer 核心变量的值是怎么变化的
 * @date 2019/12/23 11:27
 * @since 2.0.7
 */
public class BufferShow {
    public static void main(String[] args) {
        CharBuffer allocate = CharBuffer.allocate(1024);
        CharBuffer charBuffer = allocate.duplicate();
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // System.out.println("-->mark--->" + byteBuffer.mark());
        ByteBuffer duplicate = byteBuffer.duplicate();
        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->" + byteBuffer.limit()); // 1024
        System.out.println("初始时-->position--->" + byteBuffer.position()); // 0
        System.out.println("初始时-->capacity--->" + byteBuffer.capacity()); // 1024
        System.out.println("初始时-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        // 添加一些数据到缓冲区中
        String s = "Java3y";
        byteBuffer.put(s.getBytes());

        // 看一下初始时4个核心变量的值
        System.out.println("put完之后-->limit--->" + byteBuffer.limit()); // 1024
        System.out.println("put完之后-->position--->" + byteBuffer.position()); // 6
        System.out.println("put完之后-->capacity--->" + byteBuffer.capacity()); // 1024
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());
        byteBuffer.flip();
        System.out.println("flip 完之后-->limit--->" + byteBuffer.limit()); // 6
        System.out.println("flip 完之后-->position--->" + byteBuffer.position()); // 0
        System.out.println("flip 完之后-->capacity--->" + byteBuffer.capacity()); // 1024
        System.out.println("flip 完之后-->mark--->" + byteBuffer.mark());
        byte[] bytes = new byte[byteBuffer.limit()];
        //  byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
//        byteBuffer.clear();
//        byteBuffer.get(bytes);

        System.out.println("clear 完之后-->limit--->" + byteBuffer.limit()); //1024
        System.out.println("clear 完之后-->position--->" + byteBuffer.position()); // 0
        System.out.println("clear 完之后-->capacity--->" + byteBuffer.capacity()); // 1024

        System.out.println("clear 完之后-->limit--->" + duplicate.limit()); //1024
        System.out.println("clear 完之后-->position--->" + duplicate.position()); // 0
        System.out.println("clear 完之后-->capacity--->" + duplicate.capacity()); // 1024
        System.out.println("clear 完之后-->mark--->" + byteBuffer.mark());
//    byte b = byteBuffer.get(1);
//    System.out.println(b);
//    System.out.println("get完之后-->position--->" + byteBuffer.position()); // 6
//    System.out.println("get完之后-->mark--->" + byteBuffer.mark());




    }
}
