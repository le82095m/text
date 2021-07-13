import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        
        System.out.println(Thread.currentThread().getName()+"的call方法正在执行");
        return 1;

    }
}

class Main3{
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new MyCallable());
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new MyCallable());
        Thread t1 = new Thread(futureTask1);
        Thread t2 = new Thread(futureTask2);
        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName()+"的main方法执行完成");
    }
}