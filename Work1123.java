import java.util.*;
pblic class Main{
    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        while(sn.hasNextLine()) {
            String str1 = sn.nextLine();
            String str2 = sn.nextLine();
            if(str2.length() == 0){
                if(judgeIsString(new StringBuffer(str1))){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            if(str1.length() == 0){
                if(judgeIsString(new StringBuffer(str2))){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            int count = 0;
            for (int i = 0; i <= str1.length(); i++) {
                StringBuffer str3 = new StringBuffer(str1);
                str3.insert(i, str2);
                if (judgeIsString(str3)) {
                    count++;
                }
            }
            System.out.println(count);
        }
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