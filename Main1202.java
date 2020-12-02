import java.math.BigInteger;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger num = fib(sc.nextInt());
        int count = 0;
        BigInteger a = BigInteger.valueOf(0);
        while(a.equals(0)){
            BigInteger b = num;
            a = BigInteger.valueOf(10).remainder(b);
            num.divide(BigInteger.valueOf(10));
            count++;
        }
        System.out.print(count);
    }
    public static BigInteger fib(int num){
        BigInteger output = BigInteger.valueOf(1);
        while(num>0){
            BigInteger a = BigInteger.valueOf(num);
            output = output.multiply(a);
            num--;
        }
        return output;
    }
}