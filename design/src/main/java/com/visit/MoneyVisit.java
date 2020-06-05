package com.visit;

import java.math.BigDecimal;

public class MoneyVisit extends Visit {
    @Override
    public BigDecimal visit(Money money) {
        BigDecimal money1 = money.getMoney();
        System.out.println(money1.toString());
        return money1;
    }
}
