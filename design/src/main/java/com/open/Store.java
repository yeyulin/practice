package com.open;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 10:21
 * @since palm.1.2.0
 **/
public class Store {
    private static final List<IBook>books=new ArrayList<>();
    static {
        books.add(new NovelBook("书一","叶",1000L));
        books.add(new NovelBook("书二","叶",100L));
        books.add(new NovelBook("书三","叶",10L));
    }

    public static void main(String[] args) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setMaximumFractionDigits(2);

        for (IBook book : books) {
            System.out.println(book);

        }
        IBook iBook = books.get(0);
        BookRebate bookRebate=new BookRebate();
        bookRebate.setiBook(iBook);
        bookRebate.setRebate(new Rebate(80));
        Long price = bookRebate.getPrice();
        System.out.println(price/100);
    }
}
