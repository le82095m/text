package lock;

public class DeadLock {
    private static Integer A = 0;
    private static Integer B = 10;

    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A:正在执行...");
                System.out.println("线程A:开始获取A对象锁...");
                synchronized (A){
                    System.out.println("线程A:获取A对象锁成功");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程A:线程A开始获取B对象...");
                    System.out.println("线程A:获取B对象锁成功");
                    synchronized (B){
                        Integer t = A;
                        A = B;
                        B = t;
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B:正在执行...");
                System.out.println("线程B:开始获取B对象锁...");
                synchronized (B){
                    System.out.println("线程B:获取B对象锁成功");
                    System.out.println("线程B:开始获取A对象锁...");
                    synchronized (A){
                        System.out.println("线程B:获取A对象锁成功");
                        System.out.println(A);
                        System.out.println(B);
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
