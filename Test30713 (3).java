import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"run()方法执行中");
    }
}

class Main4{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable myRunnable = new MyRunnable();
        for(int i = 0; i < 5; i++){
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }
}