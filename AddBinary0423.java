package work;

import java.util.Deque;
import java.util.LinkedList;

public class AddBinary {
    public String addBinary(String a, String b) {
        Deque<Integer> stack = new LinkedList<>();
        int size = Math.min(a.length(),b.length());
        int poor = Math.abs(a.length()-b.length());
        int carry = 0;
        int i;
        if(a.length() > b.length()){
            for( i = size-1 ;i >= 0 ;i--){
                int num = carry + (a.charAt(i+poor)-'0') + (b.charAt(i)-'0');
                if(num < 2){
                    stack.push(num);
                    carry = 0;
                }else{
                    stack.push(num-2);
                    carry = 1;
                }
            }
            for(i = poor-1 ;i >= 0 ;i--){
                int num = carry + a.charAt(i)-'0';
                if(num < 2){
                    stack.push(num);
                    carry = 0;
                }else{
                    stack.push(num-2);
                    carry = 1;
                }
            }
        }else if(a.length() < b.length()){
            for( i = size-1 ;i >= 0 ;i--){
                int num = carry + (a.charAt(i)-'0') + (b.charAt(i+poor)-'0');
                if(num < 2){
                    stack.push(num);
                    carry = 0;
                }else{
                    stack.push(num-2);
                    carry = 1;
                }
            }
            for(i = poor-1 ;i >= 0 ;i--){
                int num = carry + b.charAt(i)-'0';
                if(num < 2){
                    stack.push(num);
                    carry = 0;
                }else{
                    stack.push(num-2);
                    carry = 1;
                }
            }
        }
        if(carry == 1){
            stack.push(1);
        }
        String s = "";
        while (!stack.isEmpty()){
            int num = stack.pop();
            s = s+num;
        }
        return s;
    }
}