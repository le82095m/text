package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public volatile static int COUNT = 0;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread[] threads = new Thread[20];//创建一个线程数组同于存放接下来创建的线程
        for(int i = 0; i < threads.length; i++){
            Runnable r = new Runnable() {//使用匿名内部类创建线程
                @Override
                public void run() {
                    for(int i = 0; i < 1000;i++) {
                        lock.lock();
                        try {
                            COUNT++;
                        }finally {
                            lock.unlock();
                        }
                    }
                }
            };
            threads[i] = new Thread(r);
        }
        for(Thread t : threads){//依次启动这20个线程
            t.start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();//保证Thread数组中的所有线程都跑完
        }
        System.out.println(COUNT);
    }
}
