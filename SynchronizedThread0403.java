package lesson3;

public class SynchronizedThread {

private static int COUNT = 1;

static class Seat implements Runnable{
    private int num;

    public Seat(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        for(int i = 0; i < 100;i++){
            synchronized (Seat.class) {
                if (COUNT <= 50 &&  num > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            "的学生"+ num-- +"在座位" + COUNT++ + "上");
                }
            }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Seat(10),"张老师").start();
        new Thread(new Seat(20),"王老师").start();
        new Thread(new Seat(20),"刘老师").start();
    }
}
