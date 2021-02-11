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

     /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算两个数之和
         * @param s string字符串 表示第一个整数
         * @param t string字符串 表示第二个整数
         * @return string字符串
         */
        public String solve (String s, String t) {
            int sIndex = s.length()-1;
            int tIndex = t.length()-1;
            int carry = 0;
            String outPut = "";
            StringBuffer str = new StringBuffer("");
            while(sIndex >= 0 && tIndex >= 0){
                int num = (s.charAt(sIndex)-'0')+(t.charAt(tIndex)-'0')+carry;
                carry = num / 10;
                str.insert(0, num % 10);
                sIndex--;
                tIndex--;
            }
            while(sIndex >= 0){
                int num = (s.charAt(sIndex)-'0')+carry;
                str.insert(0,num % 10);
                sIndex--;
                carry = num / 10;
            }
            while(tIndex >= 0){
                int num = (t.charAt(tIndex)-'0')+carry;
                str.insert(0,num % 10);
                tIndex--;
                carry = num / 10;
            }
            if(carry != 0){
                str.insert(0,carry);
            }
            outPut = str.toString();
            return outPut;
        }
}