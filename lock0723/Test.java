package lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    public static int COUNT;
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10,
                30,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                new ThreadPoolExecutor.DiscardPolicy());


        Lock lock = new ReentrantLock();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    lock.lock();
                    try {
                        COUNT++;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };


        for(int i = 0 ;i < 20; i++) {
            pool.execute(r);
        }
        while (pool.getActiveCount() > 0){
            Thread.yield();
        }
        pool.shutdown();
        System.out.println(COUNT);
    }
}
