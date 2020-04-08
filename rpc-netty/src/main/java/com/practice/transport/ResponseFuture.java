package com.practice.transport;

import com.practice.transport.command.Command;

import java.util.concurrent.CompletableFuture;

/**
 * @author yeyulin
 * @description: 异步请求，特用Future来存放返回的结果
 * @date 2020/1/8 10:28
 * @since 2.0.7
 **/
public class ResponseFuture {
    /**
     * 请求的唯一标识
     */
    private final int requestId;
    /**
     * 异步结果
     */
    private final CompletableFuture<Command> future;
    /**
     * 时间戳
     */
    private final long timestamp;

    public ResponseFuture(int requestId, CompletableFuture<Command> future) {
        this.requestId = requestId;
        this.future = future;
        timestamp = System.nanoTime();
    }

    public int getRequestId() {
        return requestId;
    }

    public CompletableFuture<Command> getFuture() {
        return future;
    }

    long getTimestamp() {
        return timestamp;
    }
}
