package test;

class T <E> {
    public void print() {
        System.out.println("可执行");
    }
}

public class Test5 {
    public static void main(String[] args) {
        int a = 10;
        Integer b = new Integer(10);
        System.out.println(a == b);
    }
}
