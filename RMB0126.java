import java.util.Scanner;

public class RMB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String money = sc.nextDouble()+"";
        StringBuilder fist = new StringBuilder();
        StringBuilder last = new StringBuilder();
        String isInt = "整";
        int i = 0;
        for (; i < money.length(); i++) {
            if(money.charAt(i) == '.'){
                break;
            }
                fist.append(money.charAt(i));
        }
        for (int j = i+1; j < money.length(); j++) {
            last.append(money.charAt(j));
            if(money.charAt(j)-'0' !=0){
                isInt = "";
            }
        }
        System.out.println("人民币"+firstPart(fist.toString())+"元"+isInt+lastPart(last.toString()));
    }
    public static StringBuilder firstPart(String str){
        StringBuilder putOut = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(str.length()-i-1)-'0';
            putOut.insert(0, count(num) + unit1(i,num));
        }
        return putOut;
    }
    public static StringBuilder lastPart(String str){
        StringBuilder outPut = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i)-'0';
            outPut.append(count(num)).append(unit2(i,num));
        }
        return outPut;
    }
    public static String unit1(int index,int num){
        String res = "";
        if(num != 0) {
            switch (index % 4) {
                case 0:
                    res = "";
                    break;
                case 1:
                    res = "拾";
                    break;
                case 2:
                    res = "佰";
                    break;
                case 3:
                    res = "仟";
            }
        }else {
            res = "零";
        }
        if(index == 4){
            res += "万";
        }
        if(index == 8){
            res += "亿";
        }
        return res;
    }
    public static String unit2(int index,int num){
        if(num != 0) {
            switch (index) {
                case 0:
                    return "角";
                case 1:
                    return "分";
                default:
                    return "";
            }
        }
        return "";
    }
    public static String count(int num){
        switch (num){
            case 1:
                return "壹";
            case 2:
                return "贰";
            case 3:
                return "叁";
            case 4:
                return "肆";
            case 5:
                return "伍";
            case 6:
                return "陆";
            case 7:
                return "柒";
            case 8:
                return "捌";
            case 9:
                return "玖";
            default:
                return "";
        }
    }
}