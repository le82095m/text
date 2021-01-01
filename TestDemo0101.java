class ExampleDemo{

    private int a;
    private int b;
    private String str;
    private static int count;
    public ExampleDemo(){
        {
            System.out.println("普通代码块");
        }
        //普通代码块
    }
    {
        this.a = 10;
        this.b = 45;
        this.str = "hello";
        System.out.println("实例代码块");
    }
    //实例代码块
    static{
        count = 100;
        System.out.println("静态代码块优先");
    }
    //静态代码块
    public void show(){
        System.out.println(this.a+" "+this.b+" "+this.str+" "+count);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        ExampleDemo ed = new ExampleDemo();
    }
}
