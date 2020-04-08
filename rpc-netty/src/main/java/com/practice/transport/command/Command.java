package com.practice.transport.command;

/**
 * @author yeyulin
 * @description: 自己定义一个协议 极其简陋的协议 ，仅包含头与内容
 * @date 2020/1/8 9:56
 * @since 2.0.7
 **/
public class Command {
    private Header header;
    private byte[] payload;

    public Command() {
    }

    public Command(Header header, byte[] payload) {
        this.header = header;
        this.payload = payload;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }
}
