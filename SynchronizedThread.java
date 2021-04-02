package lesson3;

class Seat implements Runnable{
    private static int COUNT = 50;
    @Override
    public void run() {
        int num = 1;
        for(int i = 0; i < 1000 ;i++){
            synchronized (this) {
                if(COUNT > 0 && num <= 100){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "的学生" + num++ + "在座位" + COUNT-- + "上");
                }
            }
        }
    }
}
public class SynchronizedThread {
    public static void main(String[] args) throws InterruptedException {
        Seat s = new Seat();
        Thread t1 = new Thread(s,"张老师");
        Thread t2 = new Thread(s,"王老师");
        Thread t3 = new Thread(s,"刘老师");
        Thread[] threads = new Thread[]{t1,t2,t3};
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
    }
}
