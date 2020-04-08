package com.practice.transport.command;


/**
 * @author yeyulin
 * @description: 返回头
 * @date 2020/1/8 10:07
 * @since 2.0.7
 **/
public class ResponseHeader extends Header {
    /**
     * 响应状态 0成功
     */
    private int code;
    /**
     * 错误原因
     */
    private String error;
    public ResponseHeader(int type, int version, int requestId,  Throwable throwable) {
        this(type, version, requestId, Code.UNKNOWN_ERROR.getCode(), throwable.getMessage());
    }
    public ResponseHeader(int type, int version, int requestId) {
        this(type, version, requestId, Code.SUCCESS.getCode(), null);
    }

    public ResponseHeader(int type, int version, int requestId, int code, String error) {
        super(type, version, requestId);
        this.code = code;
        this.error = error;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
