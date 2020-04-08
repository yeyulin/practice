package com.open;

/**
 * @author yeyulin
 * @description:
 * @date 2020/4/1 10:27
 * @since palm.1.2.0
 **/
public class Rebate {
    private Integer discount;

    public Rebate(Integer discount) {
        this.discount = discount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rebate{");
        sb.append("discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }
}
