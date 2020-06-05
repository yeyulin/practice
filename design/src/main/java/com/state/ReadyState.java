package com.state;

public class ReadyState extends AbstractSate {
    @Override
    protected void open() {
        System.out.println("ERROR 准备阶段不能打开");
    }

    @Override
    protected void ready() {
        System.out.println("打开");
    }

    @Override
    protected void run() {

    }

    @Override
    protected void stop() {

    }

    @Override
    protected void close() {
        super.setStateContext(StateContext.closeState.getStateContext());
    }
}
