import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(1234567)));
    }
    public static int[] exchange(long n){
        if(n == 0){
            return new int[]{0};
        }
        Deque<Integer> stack = new LinkedList<>();
        while(Math.abs(n) > 0){
            long num = (n % 10);
            stack.push((int)num);
            n /= 10;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
