package lesson6;

public class SingnolTest {
    public static void main(String[] args) throws InterruptedException {
        //竞争class对象锁
        synchronized (SingnolTest.class) {
            //当前线程释放对象锁
            SingnolTest.class.wait();
            //通知调用同一个对象的wait方法阻塞的线程（唤醒），唤醒后竞争对象锁
            SingnolTest.class.notify();
        }//释放对象锁
    }
}
