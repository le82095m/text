package lesson3;

public class MethodArgument {
    public static void fun(int i){//fun方法栈帧
        i = 1;
    }

    //main线程，执行main方法(栈帧)
    public static void main(String[] args) {
        int i = 0;
        fun(i);//产生方法调用
        System.out.println(i);
    }
}
