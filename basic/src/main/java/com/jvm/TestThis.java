package com.jvm;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/9 17:02
 * @since 2.0.7
 **/
public class TestThis {
    public static void main(String[] args) {
        TestThis testThis=new TestThis();
        testThis.in();
    }
    private void in(){
        out();
        this.out();
    }
    private void out(){
        System.out.println("22");
    }
}
