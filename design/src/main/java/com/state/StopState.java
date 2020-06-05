package com.state;

public class StopState extends AbstractSate {
    @Override
    protected void open() {

    }

    @Override
    protected void ready() {

    }

    @Override
    protected void run() {

    }

    @Override
    protected void stop() {
        System.out.println("关闭");
    }

    @Override
    protected void close() {

    }
}
