import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            hexadecimalConversion(sc.nextLine());
        }
    }
    public static void statistics(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer count = map.getOrDefault(str.charAt(i),0);
            map.put(str.charAt(i),++count);
        }
        for (char i = 'A'; i <='Z' ; i++) {
            System.out.println(i+":"+map.getOrDefault(i,0));
        }
    }
    public static void hexadecimalConversion(String str){
        int num = 0;
        for (int i = 0; i < str.length()-2; i++){
            num += conversion(str.charAt(str.length()-1 - i))*Math.pow(16,i);
        }
        System.out.println(num);
    }
    public static int conversion(char c){
        int num = c-'0';
        if(num > 9){
            num -= 7;
        }
        return num;
    }
}