package com.open;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 10:28
 * @since palm.1.2.0
 **/
public class BookRebate {
    private Rebate rebate;
    private IBook iBook;

    public Rebate getRebate() {
        return rebate;
    }

    public IBook getiBook() {
        return iBook;
    }

    public void setRebate(Rebate rebate) {
        this.rebate = rebate;
    }

    public void setiBook(IBook iBook) {
        this.iBook = iBook;
    }
    public Long getPrice(){
        Long price = iBook.getPrice();
       return price*rebate.getDiscount();
    }
}
