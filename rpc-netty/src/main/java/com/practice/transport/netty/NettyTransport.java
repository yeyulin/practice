package com.practice.transport.netty;

import com.practice.transport.Transport;
import com.practice.transport.command.Command;

import java.util.concurrent.CompletableFuture;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/8 10:16
 * @since 2.0.7
 **/
public class NettyTransport implements Transport {

    @Override
    public CompletableFuture<Command> send(Command request) {
        return null;
    }
}
