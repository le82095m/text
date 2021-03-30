package lesson2;

public class YieldThread4 {
    public static void main(String[] args) {
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
        }
        while(Thread.activeCount() > 1){//获取当前线程的线程存活数(包含当前线程)
            Thread.yield();//当前线程让步由运行态变为就绪态
        }
        System.out.println("OK");//main主线程和其20个子线程都同时为可执行态
    }
}
