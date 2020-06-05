package com.visit;

public class Test {
    public static void main(String[] args) {
        Money newMoney=new NewMoney();
        Money oldMoney=new OldMoney();
        oldMoney.accept(new MoneyVisit());
        oldMoney.accept(new PersonVisit());

        newMoney.accept(new MoneyVisit());
        newMoney.accept(new PersonVisit());
    }
}
