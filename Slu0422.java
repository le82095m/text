package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(comp(stack.peek(),s.charAt(i))){
                    stack.remove();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean comp(char a,char b){
        switch(a){
            case '(':
                return b == ')';
            case '[':
                return b == ']';
            case '{':
                return b == '}';
            default :
                return false;
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        int i = 0;
        while(i < k && k <= input.length){
            list.add(input[i++]);
        }
        return list;
    }
}

