package lesson;

public class Thread_study4 {
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    for(int i = 0; i < 1000000000; i++) {
                        if (i == 999999999) {
                            System.out.println(i);
                        }
                    }
                }
            };
            t.start();
        }
    }
}
