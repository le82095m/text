package com.le.tomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolStart {
    private final ThreadPoolExecutor pool;

    public PoolStart() {
        this.pool = new ThreadPoolExecutor(
                4,//corePoolSize:核心线程数
                10,//maximumPoolSize:最大线程数(核心线程+临时线程)
                60,//keepAliveTime:空闲时间数(临时线程可空闲的最长时间，超过该时间临时线程就会被销毁)
                TimeUnit.SECONDS,//unit:时间单位
                new ArrayBlockingQueue<>(1000),//workQueue:阻塞队列(存放线程的容器)
                new ThreadPoolExecutor.DiscardPolicy());//handler:拒绝策略
    }


    public void processing(ServerSocket serverSocket) throws IOException {
        int i = 0;
        while (i < 100){
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            pool.execute(task);
            i++;
        }
        pool.shutdown();
    }
}
