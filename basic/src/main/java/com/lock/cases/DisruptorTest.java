package com.lock.cases;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/5 16:40
 * @since 2.0.7
 **/
public class DisruptorTest {

    public static void main(String[] args) throws InterruptedException {
        //指定RingBuffer大小,
        //必须是2的N次方
        int bufferSize = 1024;
        //  EventFactory<T> eventFactory, int ringBufferSize, Executor executor
        ExecutorService service = Executors.newFixedThreadPool(1);
        //构建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(
                LongEvent::new,
                bufferSize,
                service);

        //注册事件处理器
        disruptor.handleEventsWith(
                (event, sequence, endOfBatch) ->
                        System.out.println("E: " + event));

//启动Disruptor
        disruptor.start();

        //获取RingBuffer
        RingBuffer<LongEvent> ringBuffer
                = disruptor.getRingBuffer();
        //生产Event
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            //生产者生产消息
            ringBuffer.publishEvent(
                    (event, sequence, buffer) ->
                            event.set(buffer.getLong(0)), bb);
            Thread.sleep(1000);
        }

    }

}

//自定义Event
class LongEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}



