import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NC90 {
    public Deque<Integer> stack = new LinkedList<>();
    public Deque<Integer> minStask = new LinkedList<>();
    /**
     * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
     *
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        List<Integer> list = new ArrayList<>();
        for(int[] arr : op){
            switch(arr[0]){
                case 1:
                    push(arr[1]);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    list.add(getMin());
                    break;
            }
        }
        int[] nums = new int[list.size()];
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
    public void push(int num){
        stack.push(num);
        if(minStask.isEmpty() || num < minStask.peek()){
            minStask.push(num);
        }else{
            minStask.push(minStask.peek());
        }
    }
    public boolean pop(){
        if(!stack.isEmpty()){
            stack.pop();
            minStask.pop();
            return true;
        }
        return false;
    }
    public int getMin(){
        return minStask.peek();
    }
}
