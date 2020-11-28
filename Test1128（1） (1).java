import java.util.Stack;

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(stack1.size() > 1){
            stack2.push(stack1.pop());
        }
        int num = stack1.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return num;
    }
    public String toString(){
        return stack1.toString();
    }
}
public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.pop();
        s.push(7);
        s.pop();
        System.out.println(s.toString());
    }
}
