package lesson2;

public class YieldThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {//内部类使用外部变量，必须是final修饰
                System.out.println("t");
            }
        });
        t.start();
        System.out.println("OK");
    }
}
