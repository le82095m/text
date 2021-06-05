package nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            while(sc.hasNext()){
                int num = sc.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = 0; i < num; i++){
                    list.add(sc.nextInt());
                }
                System.out.println(theMinOnlyOne(list));
            }
        }
        public static int theMinOnlyOne(ArrayList<Integer> list){
            Map<Integer,Integer> map = new HashMap<>();
            for(int num : list){
                int count = map.getOrDefault(num,0);
                map.put(num,++count);
            }
            int max = 9999999;
            for(int num : map.keySet()){
                if(map.get(num) == 1){
                    max = max < num ? max : num;
                }
            }
            if(max == 9999999){
                max = -1;
            }
            return max;
        }
}
