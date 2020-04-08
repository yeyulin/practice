package com.practice.transport.command;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/8 10:02
 * @since 2.0.7
 **/
public class Header {
    /**
     * 一次请求的唯一标识
     */
    private int requestId;

    /**
     * 协议的版本号
     */
    private int version;
    /**
     * 请求的类型，方便路由分发
     */
    private int type;

    public Header() {
    }

    public Header(int requestId, int version, int type) {
        this.requestId = requestId;
        this.version = version;
        this.type = type;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
