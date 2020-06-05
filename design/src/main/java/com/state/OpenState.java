package com.state;

public class OpenState extends AbstractSate {
    @Override
    protected void open() {
        System.out.println("准备open");
    }

    @Override
    protected void ready() {
        super.setStateContext(StateContext.readyState.getStateContext());
    }

    @Override
    protected void run() {

    }

    @Override
    protected void stop() {

    }

    @Override
    protected void close() {
        super.getStateContext().setContext(StateContext.closeState);
    }
}
