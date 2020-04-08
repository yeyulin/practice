package com.open;

import java.text.NumberFormat;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 10:19
 * @since palm.1.2.0
 **/
public class NovelBook implements IBook {
    private String name;
    private String author;
    private Long price;

    public NovelBook(String name, String author, Long price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public Long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setMaximumFractionDigits(2);

        final StringBuilder sb = new StringBuilder("NovelBook{");
        sb.append("name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", price=").append(currencyInstance.format(price));
        sb.append('}');
        return sb.toString();
    }
}
