package com.blame;

public class TwoThousandHandle extends Ihandle {
    public TwoThousandHandle(Long level) {
        super(level);
    }

    @Override
    protected void handle(Whoring whoring) {
        Long money = whoring.getMoney();
        System.out.println("我的级别是两千元我出了" + money);
    }
}
