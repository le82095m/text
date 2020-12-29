package WorkDemo;


import java.util.Deque;
import java.util.LinkedList;

public class Function {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int param_2 = myStack.pop();
        int param_3 = myStack.top();
        boolean param_4 = myStack.empty();
        System.out.println(param_2+" "+param_3+" "+param_4);
    }
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (Character c : str) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                switch (c) {
                    case (')'):
                        if (!stack.pop().equals('(')) {
                            return false;
                        }
                        break;
                    case (']'):
                        if (!stack.pop().equals('[')) {
                            return false;
                        }
                        break;
                    case ('}'):
                        if (!stack.pop().equals('{')) {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
