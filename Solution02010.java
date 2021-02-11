import java.util.*;


public class Solution {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{1, 2, 3, 4, 5}));
    }
    public static int maxLength (int[] arr) {
        int sum = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(noRepeat(arr,i,j)){
                    sum = sum > (j-i+1) ? sum : (j-i+1);
                }
            }
        }
        return sum;
    }
    public static boolean noRepeat (int[] arr,int start,int end){
        Set<Integer> set = new HashSet<>();
        for(int i = start; i <= end; i++){
            set.add(arr[i]);
        }
        return set.size() == (end - start + 1);
    }
}