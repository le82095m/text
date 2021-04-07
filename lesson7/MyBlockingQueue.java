package lesson7;

public class MyBlockingQueue<T> {
    private static Object[] queue;
    private static int getIndex;
    private static int tackIndex;
    private static int size;

    public MyBlockingQueue(int len){
        queue = new Object[len];
    }

    public synchronized void put(T e) throws InterruptedException {
        while (size >= queue.length){
            throw new RuntimeException();
        }
        while(tackIndex > size-1){
            this.wait();
        }
        queue[tackIndex] = e;
        tackIndex++;
        size++;
        if(tackIndex > size-1){
            tackIndex = 0;
        }
        this.notifyAll();
    }

    public synchronized Object get(int index) throws InterruptedException {
        if(index > size-1 || index < 0){
            throw new RuntimeException();
        }
        while (queue[index] == null){
            this.wait();
        }
        this.notifyAll();
        return (Object) queue[index];
    }

    public synchronized int getSize(){
        return  size;
    }
}
