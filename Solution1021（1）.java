import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            int num;
            for (String s : tokens) {
                switch (s) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        num = stack.pop();
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        stack.push(Integer.valueOf(s));
                        break;
                }
            }
            return stack.pop();
        }
    }
