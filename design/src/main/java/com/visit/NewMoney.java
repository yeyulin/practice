package com.visit;

import java.math.BigDecimal;

public class NewMoney implements Money {
    @Override
    public BigDecimal getMoney() {
        return BigDecimal.valueOf(1_000);
    }

    @Override
    public void accept(Visit visit) {
        if(visit instanceof MoneyVisit){
            visit.visit(this);
        }else {
            System.out.println("只允许金钱访问者访问");
        }

    }
}
