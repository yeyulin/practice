package com.visit;

import java.math.BigDecimal;

public interface Money {
    BigDecimal getMoney();

    void accept(Visit visit);
}
