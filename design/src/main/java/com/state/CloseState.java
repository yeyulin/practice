package com.state;

public class CloseState extends AbstractSate {
    @Override
    protected void open() {
        super.getStateContext().setContext(StateContext.openState);
    }

    @Override
    protected void ready() {

    }

    @Override
    protected void run() {

    }

    @Override
    protected void stop() {
        System.out.println("关闭后不能停止");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
