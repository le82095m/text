import java.util.Stack;

public class solution {
    /**
     *
     * 用两个栈来实现一个队列
     * 完成队列的Push和Pop操作。 队列中的元素为int类型。
     *
     * */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    /**
     *
     * 大家都知道斐波那契数列，现在要求输入一个整数n
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）
     * */
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n < 3){
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        while(n > 2){
            a = b + c;
            b = a + c;
            c = a + b;
            n-=3;
        }
        switch(n % 3){
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            default:
                return 0;
        }
    }
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }


    /**
     *
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
     * */
    public double Power(double base, int exponent) {
        double d = 1.0;
        if(exponent > 0){
            for(int i = 0; i < exponent ; i++){
                d *= base;
            }
        }else{
            for(int i = exponent; i < 0; i++){
                d /= base;
            }
        }
        return d;
    }
}
