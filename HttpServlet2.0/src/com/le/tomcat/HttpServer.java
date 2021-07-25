package com.le.tomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//corePoolSize:核心线程数
                10,//maximumPoolSize:最大线程数(核心线程+临时线程)
                60,//keepAliveTime:空闲时间数(临时线程可空闲的最长时间，超过该时间临时线程就会被销毁)
                TimeUnit.SECONDS,//unit:时间单位
                new ArrayBlockingQueue<>(1000),//workQueue:阻塞队列(存放线程的容器)
                new ThreadFactory(){//threadFactory:匿名内部类
                    @Override
                    public Thread newThread(Runnable r){
                        //线程的工厂类
                        return new Thread(r);
                    }
                },
                //handler:拒绝策略
                new ThreadPoolExecutor.DiscardPolicy());
        ServerSocket serverSocket = new ServerSocket(8080);

        //1. 找到所有的Servlet对象，进行初始化

        //2.每次循环处理一个请求
        int i = 0;
        while (i < 100){
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            pool.execute(task);
            i++;
        }
        pool.shutdown();

        //3. 找到所有的 Servlet 对象，销毁
    }
}
