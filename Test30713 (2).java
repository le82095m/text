class MyRunnable implements Runnable{



    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"的run方法正在执行");

    }
}

class Main{
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+"的main方法正在执行");
    }
}