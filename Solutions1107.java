package leetCode;

class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int min = strs[0].length();
        for(int i = 0; i < strs.length-1;i++){
            int num = compareSting(strs[i],strs[i+1]);
            min = Math.min(min,num);
        }
        return strs[0].substring(0,min);
    }
    public int compareSting(String str1,String str2){
        int i = 0;
        while(i < Math.min(str1.length(),str2.length())){
            if(str1.charAt(i) != str2.charAt(i)){
                break;
            }
            i++;
        }
        return i;
    }
}
