package lesson3;

public class SynchronizedThread3 {
    /**
     *
     * 有一个教室，座位有50个，同时有三个老师安排同学的座位
     * 每个老师安排100个同学到这个教室，模拟使用多线程实现
     * 座位编号1 ~ 50，三个线程同时启动安排同学1~300
     *
     * */
    private static int COUNT;
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];
        for(int i = 0; i < 3 ;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int num = 0;
                    while (COUNT < 50) {
                        synchronized (this) {
                            COUNT++;
                            num++;
                        }
                    }
                    System.out.println(num+" ");
                }
            });
        }
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
    }
}
