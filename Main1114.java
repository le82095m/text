package work;

public class Main {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s.minData());
        s.pop();
        System.out.println(s.peek());
    }
}
