package com.visit;

import java.math.BigDecimal;

public class OldMoney implements Money {
    @Override
    public BigDecimal getMoney() {
        return BigDecimal.valueOf(100_000);
    }

    @Override
    public void accept(Visit visit) {
        visit.visit(this);
    }
}
