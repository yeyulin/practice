package com.practice.serialize;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/7 13:52
 * @since 2.0.7
 **/
public class SerializeException extends RuntimeException {
    public SerializeException(String msg) {
        super(msg);
    }
    public SerializeException(Throwable throwable){ super(throwable);}
}
