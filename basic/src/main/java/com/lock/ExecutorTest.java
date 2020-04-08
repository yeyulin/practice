package com.lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/25 15:17
 * @since 2.0.7
 **/
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //获得一个线程池
        ExecutorService service = Executors.newFixedThreadPool(1);
        Result result = new Result();
        result.setName("王华");
        System.out.println();
        System.err.println();
        Future<Result> future = service.submit(new Task(result), result);

        if (!future.isDone()) {
            Result result1 = future.get(10, TimeUnit.SECONDS);
            System.out.println(result == result1);
            List<Integer> integers = Arrays.asList(1, 2, 3, 4);
            boolean b = integers.stream().anyMatch(v -> v.equals(6));
            System.out.println(b);
        }
    }

    static class Task implements Runnable {
        private Result result;

        public Task(Result result) {
            this.result = result;
        }

        //TODO 很多业务逻辑处理方法
        public void op1(String name) {

            if ("王华".equals(name)) {
                result.setAge(22);
            } else {
                result.setAge(20);
            }
        }

        @Override
        public void run() {
            op1(result.getName());
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }
    }
}
