package lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<String>();
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//核心线程数
                10,//最大线程数(核心线程+临时线程)
                60,//空闲时间数(临时线程可空闲的最长时间，超过该时间临时线程就会被销毁)
                TimeUnit.SECONDS,//时间单位
        new ArrayBlockingQueue<>(1000),//阻塞队列(存放线程的容器)
                new ThreadFactory(){//匿名内部类
                    @Override
                    public Thread newThread(Runnable r){
                        //线程的工厂类
                        return new Thread(r);
                    }
                },
                // 拒绝策略
                //1. new ThreadPoolExecutor.AbortPolicy()//抛异常的方式
                //2. new ThreadPoolExecutor.CallerRunsPolicy()//
                //3. new ThreadPoolExecutor.DiscardOldestPolicy()//把阻塞队列存放时间最久的任务丢弃
                //4.
                new ThreadPoolExecutor.DiscardPolicy());//不处理该任务，直接丢弃

        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
                System.out.println("线程"+Thread.currentThread().getName()+":");
                System.out.println("commStr:"+commStr);
                System.out.println("threadStr:"+threadStr.get());
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+":");
        System.out.println("commStr:"+commStr);
        System.out.println("threadStr:"+threadStr.get());
    }
}
