import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        int size = 0;
        while(sc.hasNext()){
            int num = sc.nextInt();
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
            size++;
        }
        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            if(m.getKey() > size/2){
                System.out.println(m.getKey());
            }
        }
    }
}
