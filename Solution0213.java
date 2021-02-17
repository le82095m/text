public class Solution {
    /**
     *
     * @param str string字符串 
     * @return int整型
     */
    public int atoi (String str) {
        int num = 0;
        int p = 0;
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                num += (str.charAt(i)-'0')*Math.pow(10,p);
                p++;
            }else if(str.charAt(i) == '+'){
                break;
            }else if(str.charAt(i) == '-'){
                if(num-1 == 2147483646){
                    num *= -1;
                    num -= 1;
                }else{
                    num *= -1;
                }
            }else if(str.charAt(i) == ' '){
                num = num;
            }else{
                num = 0;
                p = 0;
            }
        }
        return num;
    }
}