package lesson2;

public class YieldThread3 {
    public static void main(String[] args) {
        //t和main同时并发并行的执行，但因为main线程正处于运行态执行代码，很快执行后续代码
        //main和t操作本来应该乱序随机，但是先打印main概率上非常高
        Thread t = new Thread(new Runnable() {
                @Override
                public void run() {//内部类使用外部变量，必须是final修饰
                    System.out.println("t");
                }
            });//申请系统创建线程t
        t.start();//申请系统执行t，将创建态转变为就绪态，再由系统决定何时变为运行态
        //只有当执行此行代码时，main线程的时间片恰好用完，t变为可执行态，恰好分配到时间片
        //只有此种情况，t在main之前先打印
        System.out.println("main");
    }
}
