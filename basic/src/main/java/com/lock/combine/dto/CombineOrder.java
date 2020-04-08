package com.lock.combine.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/13 13:41
 * @since 2.0.7
 **/
public class CombineOrder {
    private Long id;
    private String value;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void waitResult() {
        synchronized (this) {
            if (Objects.isNull(value)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notifyResult() {
        synchronized (this) {
            notifyAll();
        }
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
