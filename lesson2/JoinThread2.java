package lesson2;

public class JoinThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++){
            final int n = i;
            //子线程休眠3秒之后,开始向下执行
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {//内部类使用外部变量，必须是final修饰
                    System.out.println(n);
                }
            });
        }

        for(Thread t : threads){
            t.start();
//            t.join();一个线程启动后并等待执行完，再启动下一个线程并等待其执行完
        }
        for (Thread t : threads){
            t.join();//所有子线程都启动后，再等待所有子线程执行完
        }
        System.out.println("OK");//main主线程和其20个子线程都同时为可执行态
    }
}
