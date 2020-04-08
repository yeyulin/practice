package com.practice.transport.netty;

import com.practice.transport.InFlightRequests;
import com.practice.transport.ResponseFuture;
import com.practice.transport.command.Command;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author yeyulin
 * @description: 用于响应返回结果，然后把结果放入到 InFlightRequests
 * @date 2020/1/8 10:23
 * @since 2.0.7
 **/
@ChannelHandler.Sharable
public class ResponseInvocation extends SimpleChannelInboundHandler<Command> {
    private static final Logger logger = LoggerFactory.getLogger(ResponseInvocation.class);
    private final InFlightRequests inFlightRequests;
    ResponseInvocation(InFlightRequests inFlightRequests) {
        this.inFlightRequests = inFlightRequests;
    }

    /**
     * 成功响应结果后，会调用该方法，
     * @param channelHandlerContext
     * @param response
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Command response) throws Exception {
        ResponseFuture future = inFlightRequests.remove(response.getHeader().getRequestId());
        if(Objects.isNull(future)){
            logger.warn("Drop response: {}", response);
            return;
        }
        future.getFuture().complete(response);
    }

    /**
     * 出现异常后
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("Exception: ", cause);
        super.exceptionCaught(ctx, cause);
        Channel channel = ctx.channel();
        if(channel.isActive()){
            ctx.close();
        }
    }
}
