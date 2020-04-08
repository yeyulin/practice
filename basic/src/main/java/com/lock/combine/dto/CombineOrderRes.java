package com.lock.combine.dto;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/13 13:51
 * @since 2.0.7
 **/
public class CombineOrderRes {
    private Long id;
    private String value;

    public CombineOrderRes(Long id, String value) {
        this.id = id;
        this.value = value;
    }

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
}
