package com.blame;

public class OneThousandHandle extends Ihandle{
    public OneThousandHandle(Long level) {
        super(level);
    }

    @Override
    protected void handle(Whoring whoring) {
        Long money = whoring.getMoney();
        System.out.println("我的级别是一千元我出了"+money);
    }
}
