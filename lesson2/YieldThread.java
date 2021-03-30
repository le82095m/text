package lesson2;

public class YieldThread {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++){
            final int n = i;
            //子线程休眠3秒之后,开始向下执行
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {//内部类使用外部变量，必须是final修饰
                    try {
                        Thread.sleep(3000);
                        System.out.println(n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        System.out.println("OK");//main主线程和其20个子线程都同时为可执行态
    }
}
