package com.blame;

public class Test {
    public static void main(String[] args) {
        Whoring whoring=new Whoring(3010L);
        Ihandle ihandle=new OneThousandHandle(1000L);
        ihandle.setNextHandle(new TwoThousandHandle(2000L));
        ihandle.handleMessage(whoring);
    }
}
