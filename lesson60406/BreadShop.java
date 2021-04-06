package lesson6;

public class BreadShop {
    private static volatile int SIZE;
    private static volatile int BREAD;

    public static class Consumer implements Runnable{
        private int count = 0;
        @Override
        public void run() {
            //一直消费
            while (count <90 && BREAD < 900){
                try {
                    if(SIZE > 0 && BREAD < 900){
                        synchronized (BreadShop.class) {
                            while(SIZE <= 0 && BREAD < 900) {
                                System.out.println("库存不足，正在制作请"+Thread.currentThread().getName()+"等待");
                                BreadShop.class.wait();
                            }
                            SIZE--;
                            count++;
                            System.out.println(Thread.currentThread().getName()+"买了一个"+
                                    "库存还剩"+SIZE);
                            BreadShop.class.notify();
//                                Thread.sleep(200);
                        }
                    }else{
                        System.out.println("库存不足，正在制作请"+Thread.currentThread().getName()+"等待");
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(BREAD < 900) {
                System.out.println(Thread.currentThread().getName() + "没钱了退出");
            }else{
                System.out.println("今日面包已卖光");
            }
        }
    }

    public static class Worker implements Runnable{
        private int count = 0;
        @Override
        public void run() {
            while(count < 30){
                try {
                    if(SIZE < 98){
                        synchronized (BreadShop.class) {
                            while (SIZE > 98) {
                                System.out.println("库存已满，请稍后制作");
                                BreadShop.class.wait();
                            }
                            SIZE+=3;
                            BREAD+=3;
                            count++;
                            System.out.println(Thread.currentThread().getName()+"制作了三个"+
                                    "库存还剩"+SIZE);
                            BreadShop.class.notify();
//                                    Thread.sleep(200);
                        }
                    }else{
                        System.out.println("库存已满，请稍后制作");
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"下班了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Consumer c = new Consumer();
        Worker w = new Worker();
//        Thread tw = new Thread(w);
//        tw.start();
        Thread[] consumers = new Thread[30];
        Thread[] workers = new Thread[10];
        for(int i = 0; i < 30;i++){
            consumers[i] = new Thread(c,"顾客"+i);
        }
        for(int i = 0; i < 10; i++){
            workers[i] = new Thread(w,"师傅"+i);
        }
        for(Thread tc : consumers){
            tc.start();
        }
        for(Thread tw : workers){
            tw.start();
        }
    }
}
