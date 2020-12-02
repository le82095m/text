import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        int i = 0;
        while(num < n){
            num = fib(i);
            i++;
        }
        int a = fib(i-1) - n;
        int b = n - fib(i-2);
        System.out.print(Math.min(a,b));
    }
    public static int fib(int i){
        if(i < 2){
            return 0;
        }
        if(i == 2){
            return 1;
        }
        return fib(i-1)+fib(i-2);
    }
}
