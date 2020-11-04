package Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//定义一个 Map 类型的顺序表
//遍历字符串,定义map(字符，出现的次数),当有一个val = 2时，重新创建一个map
//将 map 类型的顺序表遍历，找出其中map size最大的值
public class Solution1 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            List<Map<Character,Integer>> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int num = i;
                Map<Character, Integer> map = new TreeMap<>();
                while (num < s.length() ) {
                    int count = map.getOrDefault(s.charAt(num), 0);
                    count++;
                    map.put(s.charAt(num), count);
                    if (map.getOrDefault(s.charAt(num), 0) > 1) {
                        break;
                    }
                    num++;
                }
                list.add(map);
            }
            int max = 0;
            for (Map<Character,Integer> map:list) {
                max = Math.max(max, map.size());
            }
            return max;
        }
    }
}
