package lesson3;

import java.util.Arrays;

public class SynchronizedThread2 {
    /**
     *
     * 有一个教室，座位有50个，同时有三个老师安排同学的座位
     * 每个老师安排100个同学到这个教室，模拟使用多线程实现
     * 座位编号1 ~ 50，三个线程同时启动安排同学1~300
     *
     * */
    private static int count = 0;
    private static int n = 0;
    public static void main(String[] args) throws InterruptedException {
        int[] students = new int[50];
        Thread[] threads = new Thread[3];
        for(int i = 0; i < 3; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int[] nums = new int[100];
                    int index = 0;
                    int num = count;
                    for(int i = count; i < num+100 ; i++){
                        nums[index] = i;
                        index++;
                    }
                    count += 100;
                    for(int a : nums){
                        synchronized (this) {
                            if(n < 50) {
                                students[n] = a;
                                n++;
                            }
                        }
                    }
                }
            });
        }
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        System.out.println(Arrays.toString(students));
    }
}
