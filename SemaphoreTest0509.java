import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreTest {
    public static int COUNT;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        ReentrantLock lock = new ReentrantLock();
        class Test extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 1000 ;i++) {
                    lock.lock();
                    try {
                        COUNT++;
                    } finally {
                        lock.unlock();
                    }
                }
                semaphore.release();
            }
        }
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Test();
        }
        for (Thread t : threads){
            t.start();
        }
        semaphore.acquire(20);
        System.out.println(COUNT);
    }
}
