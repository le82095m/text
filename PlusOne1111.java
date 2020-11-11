package work;

import java.util.Deque;
import java.util.LinkedList;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int crray = 1;
        Deque<Integer> stack = new LinkedList();
        for(int i = digits.length-1; i >= 0; i--){
            int num = digits[i];
            if(num + crray > 9){
                stack.push(0);
                crray = 1;
            }else{
                stack.push(num + crray);
                crray = 0;
            }
        }
        if(crray == 1){
            stack.push(1);
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            arr[i] = stack.pop();
            i++;
        }
        return arr;
    }
}
