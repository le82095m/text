package nowcoder;

public class JZ49 {
    /**
     *
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数
     * 数值为0或者字符串不是一个合法的数值则返回0
     *
     **/
    public int StrToInt(String str) {
        int num = 0;
        int count = 0;
        for(int i = str.length()-1; i > 0; i--){
            char c = str.charAt(i);
            if((c<'0' || c>'9') && c != '+' && c != '-'){
                return 0;
            }
            if(c == '+'){
                continue;
            }
            if(c == '-'){
                num = -num;
                continue;
            }
            num += (c - '0')*Math.pow(10,count);
            count++;
        }
        return num;
    }
}
