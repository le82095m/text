package nowcoder;

import java.util.HashMap;
import java.util.Set;

public class JZ40 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * 一个整型数组里除了两个数字只出现一次，
     * 其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        int[] nums = new int[2];
        if(array.length == 0){
            return nums;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : array){
            int count = map.getOrDefault(i,0);
            map.put(i,++count);
        }
        Set<Integer> set = map.keySet();
        int index = 0;
        for(int num : set){
            if(map.get(num) == 1){
                nums[index++] = num;
            }
        }
        return nums;
    }
}
