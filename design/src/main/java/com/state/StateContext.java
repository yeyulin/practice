package com.state;

public class StateContext {
    private AbstractSate abstractSate;
    public static final OpenState openState = new OpenState();
    public static final CloseState closeState = new CloseState();
    public static final ReadyState readyState = new ReadyState();
    public static final RunState runState = new RunState();
    public static final StopState stopState = new StopState();

    public AbstractSate getAbstractSate() {
        return abstractSate;
    }

    /**
     * 设置抽象状态时，同时设置状态
     *
     * @param abstractSate
     */
    public void setContext(AbstractSate abstractSate) {
        this.abstractSate = abstractSate;
        this.abstractSate.setStateContext(this);
    }

    protected void open() {
        this.abstractSate.open();
    }

    protected void ready() {
        this.abstractSate.ready();
    }

    protected void run() {
        this.abstractSate.run();
    }

    protected void stop() {
        this.abstractSate.stop();
    }

    protected void close() {
        this.abstractSate.close();
    }
}
