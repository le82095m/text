package work;

import java.util.HashMap;
import java.util.Map;

public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : deck){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
        }
        for(int num : deck){
            if(map.get(num) < 1){
                return false;
            }
        }
        return true;
    }
}
