package work;

import java.util.Deque;
import java.util.LinkedList;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0){
            return 0;
        }
        Deque<Character> stack = new LinkedList();
        for(int i = 0 ;i < s.length();i++){
            stack.push(s.charAt(i));
        }
        int count = 0;
        while(!stack.isEmpty() && stack.peek() == ' '){
            stack.pop();
        }
        while(!stack.isEmpty()){
            if(stack.pop() == ' '){
                break;
            }
            count++;
        }
        return count;
    }
}
