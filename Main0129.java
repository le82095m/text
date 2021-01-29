import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(judge("AND12484AND."));
    }
    public static String judge(String str){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        if(str.length() <= 8){
            return "NG";
        }
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                a = 1;
            }else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                b = 1;
            }else if(str.charAt(i) >= '1' && str.charAt(i) <= '9'){
                c = 1;
            }else{
                d = 1;
            }
        }
        if(a+b+c+d < 3){
            return "NG";
        }
        int startIndex = 0;
        int testIndex = startIndex+3;
        int count = 0;
        while (startIndex < str.length()){
            if(testIndex+count < str.length() && str.charAt(startIndex+count) == str.charAt(testIndex+count)){
                if(count >= 2){
                    return "NG";
                }
                count++;
                continue;
            }
            count = 0;
            testIndex++;
            if(testIndex > str.length()-1){
                startIndex++;
                testIndex = startIndex+3;
            }
        }
        return "OK";
    }
}
