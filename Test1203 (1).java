import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuffer num = new StringBuffer(sc.nextLine());
        Map<Character,Integer> map = new HashMap<>();
        while(num.length() > 0){
            Character a = num.charAt(num.length()-1);
            int count = map.getOrDefault(a,0);
            count++;
            map.put(a,count);
            num.deleteCharAt(num.length()-1);
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        for(Map.Entry<Character,Integer> a : set){
            System.out.println(a.getKey()+":"+a.getValue());
        }
    }
}
