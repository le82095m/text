import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(reversal(sc.nextLine()));
    }
    public static String reversal(String str){
        if(str == null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        int last = str.length();
        for (int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == ' '){
                newStr.append(str.substring(i+1, last)).append(str.charAt(i));
                last = i;
            }
        }
        boolean a = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                newStr.append(str.substring(0,i));
                a = true;
                break;
            }
        }
        if(!a){
            return str;
        }
//        newStr.append(str);
        return newStr.toString();
    }
}
