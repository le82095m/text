import java.util.concurrent.locks.ReentrantLock;

public class ThreadStudy {
    public static int COUNT;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread[] threads = new Thread[20];
        for(int i = 0; i < 20 ; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lock.lock();
                        try {
                            COUNT++;
                        } finally {
                            lock.unlock();
                        }
//                        synchronized(ThreadStudy.class){
//                            COUNT++;
//                        }
                    }
                }
            });
            threads[i].start();
        }
        for(Thread t : threads){
            t.join();
        }
        System.out.println(COUNT);
    }
}