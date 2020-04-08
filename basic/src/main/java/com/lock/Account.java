package com.lock;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/27 15:30
 * @since 2.0.7
 **/
public class Account {
    private final StringBuffer user;

    public Account(String user) {
        this.user = new StringBuffer(user);
    }

    public StringBuffer getUser() {
        return new StringBuffer(user);
    }
    @Override
    public String toString() {
        return "user" + user;
    }

    public static void main(String[] args) {
        Account account=new Account("12");
        StringBuffer user = account.getUser();
        String string = user.append("2222").toString();
        System.out.println(string);
        System.out.println(account.getUser());
        Account account1=new Account("23");
    }
}
