package WorkDemo;

import java.util.Deque;
import java.util.LinkedList;

public class Reverse {
}
class Solution1 {
    //栈
            public int reverse(int x) {
            int num = x;
            int result = 0;
            while (num != 0){
                result = result * 10 + num % 10;
                num /= 10;
            }
            int b = result;
            int a = 0;
            while(b != 0){
                a= a * 10 + b % 10;
                b /= 10;
            }
            while(x%10 == 0 && x != 0){
                x /= 10;
            }
            if(a == x){
                return result;
            }else{
                return 0;
            }
        }
}
