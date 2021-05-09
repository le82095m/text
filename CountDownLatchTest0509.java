import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {
    public static int COUNT;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(20);
        ReentrantLock lock = new ReentrantLock();
        for(int i = 0; i < 20 ;i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lock.lock();
                        try {
                            COUNT++;
                        }finally {
                            lock.unlock();
                        }
                    }
                    latch.countDown();
                }
            });
            thread.start();
        }
        latch.await();
        System.out.println(COUNT);
    }
}
