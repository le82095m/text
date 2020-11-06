package imp;

public class MyQueue {
    public static void main(String[] args) {
        Deque myQueue = new LinkedList();
        myQueue.add(1);
        System.out.print(myQueue.element()+" ");
        myQueue.add(2);
        System.out.print(myQueue.element()+" ");
        myQueue.add(3);
        System.out.print(myQueue.element()+" ");
        myQueue.add(4);
        System.out.print(myQueue.element()+" ");
        myQueue.add(5);
        System.out.println(myQueue.remove());
        System.out.print(myQueue.element()+" ");
    }
}
