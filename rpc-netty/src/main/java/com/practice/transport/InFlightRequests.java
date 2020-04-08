package com.practice.transport;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author yeyulin
 * @description: 存放以发送请求，但没有响应结果的请求 中间保存
 *
 * @date 2020/1/8 10:17
 * @since 2.0.7
 **/
public class InFlightRequests {
    /**
     * 异步请求中，为防止出现请求挤压在内存中，新增一个背压机制，用于限制客户端请求速度
     */
    private final Semaphore semaphore = new Semaphore(10);
    private final static long TIMEOUT_SEC = 10L;
    private final Map<Integer, ResponseFuture> futureMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledFuture scheduledFuture;
    public InFlightRequests() {
        //周期性移除，每10秒移除 futureMap内以超时的任务
        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(this::removeTimeoutFutures, TIMEOUT_SEC, TIMEOUT_SEC, TimeUnit.SECONDS);
    }

    /**
     * 存放待响应的事件
     * @param responseFuture 返回结果
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public void put(ResponseFuture responseFuture) throws InterruptedException, TimeoutException {
        if(semaphore.tryAcquire(TIMEOUT_SEC, TimeUnit.SECONDS)) {
            futureMap.put(responseFuture.getRequestId(), responseFuture);
        } else {
            throw new TimeoutException();
        }
    }

    /**
     * 移除后释放信号量
     * @param requestId 请求的唯一标识
     * @return
     */
    public ResponseFuture remove(Integer requestId){
        ResponseFuture future = futureMap.remove(requestId);
        if(Objects.isNull(future)){
            semaphore.release();
        }
        return future;
    }
    public void cancel(){
        scheduledFuture.cancel(true);
        scheduledExecutorService.shutdown();
    }

    /**
     * 移除以超时的待办理任务
     */
    private void removeTimeoutFutures() {
        futureMap.entrySet().removeIf(entry -> {
            if( System.nanoTime() - entry.getValue().getTimestamp() > TIMEOUT_SEC * 1000_000_000L) {
                semaphore.release();
                return true;
            } else {
                return false;
            }
        });
    }


}
