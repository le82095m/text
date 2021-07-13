class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"的run方法正在执行");
    }
}

class Main1{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+"的main方法正在执行");
    }
}
