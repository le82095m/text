package lesson2;

public class JoinThread3 {
    public static void main(String[] args) throws InterruptedException {
        //t和main同时并发并行的执行，但因为main线程正处于运行态执行代码，很快执行后续代码
        //main和t操作本来应该乱序随机，但是先打印main概率上非常高
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {//内部类使用外部变量，必须是final修饰
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t");
            }
        });//申请系统创建线程t
        t.start();//申请系统执行t，将创建态转变为就绪态，再由系统决定何时变为运行态
        t.join(400);//当前线程限时等待，直到t线程执行完毕或等待时间已到,当前线程再往后执行
        System.out.println("main");
    }
}
