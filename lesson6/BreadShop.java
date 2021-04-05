package lesson6;

public class BreadShop {
    private static volatile int SIZE;

    public static class Consumer implements Runnable{

        @Override
        public void run() {
            //一直消费
            while (true){
                if(SIZE > 0){
                    synchronized (Consumer.class) {
                        if(SIZE > 0) {
                            SIZE--;
                            System.out.println(Thread.currentThread().getName()+"买了一个"+
                                    "库存还剩"+SIZE);
                        }else{
                            System.out.println("库存不足，正在制作请等待");
                            try {
                                Consumer.class.wait();
                                if(SIZE > 0){
                                    Consumer.class.notify();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                System.out.println("库存不足，正在制作请等待");
            }
        }
    }

    public static class Worker implements Runnable{

        @Override
        public void run() {
            while(true){
                if(SIZE < 98){
                    synchronized (Worker.class) {
                        if(SIZE < 98) {
                            SIZE+=3;
                            System.out.println(Thread.currentThread().getName()+"制作了三个"+
                                    "库存还剩"+SIZE);
                        }else{
                            System.out.println("库存已满，请稍后制作");
                            try {
                                Worker.class.wait();
                                if(SIZE < 98){
                                    Worker.class.notify();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                System.out.println("库存已满，请稍后制作");
            }
        }
    }

    public static void main(String[] args) {
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
