import java.util.Deque;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        System.out.println(judgeIsString(new StringBuffer("abd")));
    }
    public static boolean judgeIsString(StringBuffer str){
        if(str.length() == 0 || str.length() == 1){
            return true;
        }
        if(str.length() % 2 != 0){
            str.deleteCharAt(str.length() / 2);
        }
        Deque<Character> stack = new LinkedList<>();
        stack.push(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
                continue;
            }
            if(stack.peek().equals(str.charAt(i))){
                stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
