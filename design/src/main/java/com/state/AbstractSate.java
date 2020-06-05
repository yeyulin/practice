package com.state;

public abstract class AbstractSate {
    protected   abstract void open();

    protected abstract void ready();

    protected abstract void run();

    protected abstract void stop();

    protected abstract void close();
    private StateContext stateContext;

    public StateContext getStateContext() {
        return stateContext;
    }

    /**
     * 设置当前状态
     * @param stateContext
     */
    public void setStateContext(StateContext stateContext) {
        this.stateContext = stateContext;
    }
}
