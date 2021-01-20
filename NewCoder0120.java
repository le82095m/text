import java.util.Scanner;

public class NewCoder {
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(breakCoder(new StringBuffer(sc.nextLine())));
        }
    }
    public static StringBuffer breakCoder(StringBuffer str){
        if (str == null){
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ' '){
                continue;
            }
            str.deleteCharAt(i);
            if (c > 'E'){
                str.insert(i,(char) (c-5));
            }else{
                if (c == 'A'){
                    str.insert(i,'V');
                }else if(c == 'B'){
                    str.insert(i,'W');
                }else if(c == 'C'){
                    str.insert(i,'X');
                }else if(c == 'D'){
                    str.insert(i,'Y');
                }else if(c == 'E'){
                    str.insert(i,'Z');
                }
            }
        }
        return str;
    }
}
