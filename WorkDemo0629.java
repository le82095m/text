import java.util.*;

public class WorkDemo {
    public String LeftRotateString(String str,int n) {
        if(n > str.length()){
            return "";
        }
        StringBuffer s = new StringBuffer(str);
        String movedStr = s.substring(0,n);
        String newStr = s.substring(n);
        newStr = newStr.concat(movedStr);
        return newStr;
    }
    public String ReverseSentence(String str){
        int start = 0;
        Deque<String> satck = new LinkedList<>();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                String childStr = "";
                childStr += str.charAt(i);
                for(int j = start;j < i;j++){
                    childStr += str.charAt(j);
                }
                satck.push(childStr);
                start = i+1;
            }
        }
        if(start < str.length()-1){
            String childStr = "";
            for(int i = start;i < str.length();i++){
                childStr += str.charAt(i);
            }
            satck.push(childStr);
        }
        String inputStr = "";
        while(!satck.isEmpty()){
            inputStr += satck.pop();
        }
        return inputStr;
    }
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        Arrays.sort(numbers);
        int joker = 0;
        for(int a : numbers){
            if(a == 0){
                joker++;
            }
        }
        for(int i = joker; i < numbers.length-1;i++){
            int num = numbers[i+1] - numbers[i];
            while(joker > 0 && num != 1){
                joker--;
                num--;
            }
            if(num != 1){
                return false;
            }
        }
        return true;
    }
    public int Sum_Solution(int n) {
        if(n == 0){
            return 0;
        }
        return n+Sum_Solution(n-1);
    }
    public int StrToInt(String str) {
        if(str.length() == 0){
            return 0;
        }
        int num = 0;
        int isPos = 0;
        if(str.charAt(0) == '+'){
            isPos = 1;
        }else if(str.charAt(0) == '-'){
            isPos = -1;
        }else if(str.charAt(0) >= '0' && str.charAt(0) <='9'){
            num += (str.charAt(0)-'0');
        }else{
            return 0;
        }
        for(int i = 1; i < str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <='9'){
                num = num*10 + (str.charAt(i)-'0');
            }else{
                return 0;
            }
        }
        if(isPos == -1){
            num = 0-num;
        }
        return num;
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < length;i++){
            int count = map.getOrDefault(numbers[i],0);
            if(count > 0){
                duplication[0] = numbers[i];
                return true;
            }
            map.put(numbers[i],++count);
        }
        return false;
    }
}
