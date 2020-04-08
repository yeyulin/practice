package com.practice.transport;

import com.practice.transport.command.Command;

import java.util.concurrent.CompletableFuture;

public interface Transport {
    /**
     * 发送请求命令
     * @param request
     * @return future
     */
    CompletableFuture<Command>send(Command request);
}
