import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {
    public static void main(String[] args) {
        String[] strings = new String[]{"{","[","]","}","]"};
        System.out.println(fun(strings));
    }
    public static boolean fun(String[] str){
        Deque<String> stack = new LinkedList<>();
        for (String s:str) {
            if(s.equals("[")||s.equals("(")||s.equals("{")){
                stack.push(s);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                switch (s) {
                    case (")"): {
                        if (!stack.pop().equals("(")) {
                            return false;
                        }
                        break;
                    }
                    case ("]"): {
                        if (!stack.pop().equals("[")) {
                            return false;
                        }
                        break;
                    }
                    case ("}"): {
                        if (!stack.pop().equals("{")) {
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
