package com.state;

public class Test {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.setContext(StateContext.openState);
        System.out.println(stateContext.getAbstractSate().getClass().getSimpleName());
        stateContext.close();
        System.out.println(stateContext.getAbstractSate().getClass().getSimpleName());
        stateContext.stop();
        System.out.println(stateContext.getAbstractSate().getClass().getSimpleName());
//        stateContext.stop();
//        stateContext.open();
    }
}
