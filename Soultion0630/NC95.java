package Soultion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class NC95 {
    public int MLS (int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        int num = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == 1) {
                num++;
            } else if (arr[i + 1] == arr[i]) {
                continue;
            } else {
                max = Math.max(max, num);
                num = 0;
            }
        }
        return Math.max(max, num) + 1;
    }
    public int MLS_1(int[] arr){
        int max = 0;
        int num = 0;
        Set<Integer> set = new HashSet<>();
        for(int n : arr){
            set.add(n);
        }
        Integer[] array = set.toArray(new Integer[1]);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i = 0; i < array.length-1; i++){
            if(array[i+1] - array[i] == 1){
                num++;
            }else{
                max = Math.max(max, num);
                num = 0;
            }
        }
        return (Math.max(max, num))+1;
    }
}
