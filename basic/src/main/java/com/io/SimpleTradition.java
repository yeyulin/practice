package com.io;

import com.google.common.util.concurrent.RateLimiter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yeyulin
 * @description: 传统的服务设计模式
 * @date 2019/12/6 10:04
 * @since 2.0.7
 * ①　读取请求数据；
 * ②　对请求数据进行解码；
 * ③　对数据进行处理；
 * ④　对回复数据进行编码；
 * ⑤　发送回复；
 **/
public class SimpleTradition {
    public static void main(String[] args) throws InterruptedException {
        Server server=new Server();
        Thread serverThread=new Thread(server);
//        Handler handler=new Handler(new Socket());
//        Thread handlerThread=new Thread(handler);
        serverThread.start();
       // Thread.sleep(100);
     //   handlerThread.start();

    }

}
class Server implements Runnable{
//    ServerSocket socket;
//    public Server() {
//        try {
//            socket=new ServerSocket(9999);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    RateLimiter rateLimiter=RateLimiter.create(2.0);
    ExecutorService executorService = Executors.newCachedThreadPool();
    @Override
    public void run() {
        try {

            ServerSocket socket=new ServerSocket(9999);
            for (int i = 0; i < 20; i++) {
                rateLimiter.acquire();
                executorService.execute(()->{
                    try {
                        new Handler(socket.accept());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Handler implements Runnable{
    final Socket socket;

    public Handler(Socket socket) throws IOException {
        this.socket = new Socket("localhost",9999);
    }

    @Override
    public void run() {
        byte[] input = new byte[1024];
        try {
            socket.getInputStream().read(input);
            byte[] output = process(input);
            socket.getOutputStream().write(output);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] process(byte[] input) {
        byte[] result=new byte[1024];
        result[0]='1';
        result[1]='2';
        return result;
    }
}
