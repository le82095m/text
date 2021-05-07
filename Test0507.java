import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * */
class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] strings = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strings[i] = numbers[i]+"";
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index = 0;
                while(index < o1.length() && index < o2.length()){
                    if(o1.charAt(index) != o2.charAt(index)){
                        return o1.charAt(index)-o2.charAt(index);
                    }
                    index++;
                }
                return o1.length()-o2.length();
            }
        });
        StringBuilder str = new StringBuilder();
        for(String s : strings){
            str.append(s);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        Solution s = new Solution();
        s.PrintMinNumber(nums);
    }
}