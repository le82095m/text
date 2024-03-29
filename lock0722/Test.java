package lock;

public class Test {
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<String>();
    public static void main(String[] args) {
        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
                System.out.println("线程"+Thread.currentThread().getName()+":");
                System.out.println("commStr:"+commStr);
                System.out.println("threadStr:"+threadStr.get());
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+":");
        System.out.println("commStr:"+commStr);
        System.out.println("threadStr:"+threadStr.get());
    }
}
