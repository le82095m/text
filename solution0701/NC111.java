package solution;

import java.util.Arrays;
import java.util.Comparator;

public class NC111 {
    /**
     * 最大数
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve (int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strings[i] = nums[i]+"";
        }
        Arrays.sort(strings,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                int i = 0;
                for(; i < Math.min(o1.length(),o2.length()); i++){
                    if(o1.charAt(i) != o2.charAt(i)){
                        return o2.charAt(i)- o1.charAt(i);
                    }
                }
                if(o1.length() > o2.length()){
                    for(; i < o1.length(); i++){
                        if(o1.charAt(i) != o2.charAt(i-o2.length())){
                            return o2.charAt(i-o2.length())-o1.charAt(i);
                        }
                    }
                }else if(o1.length() < o2.length()){
                    for(; i < o2.length(); i++){
                        if(o1.charAt(i-o1.length()) != o2.charAt(i)){
                            return o2.charAt(i)-o1.charAt(i-o1.length());
                        }
                    }
                }
                return 0;
            }
        });
        String str = "";
        for(String s : strings){
            str += s;
        }
        if(str.charAt(0) == '0'){
            return "0";
        }
        return str;
    }
}
