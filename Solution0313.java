import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String aucStr = sc.nextLine();
            char[] aucResult = new char[aucStr.length()];
            Encrypt(aucStr.toCharArray(),aucResult);
            String str = sc.nextLine();
            char[] password = new char[str.length()];
            unEncrypt(str.toCharArray(),password);
            for(char c : aucResult){
                System.out.print(c);
            }
            System.out.println("");
            for(char c : password){
                System.out.print(c);
            }
            System.out.println("");
        }
    }
    public static void Encrypt(char[] aucPassword,char[] aucResult){
        for(int i = 0; i < aucPassword.length; i++){
            char c = aucPassword[i];
            if(c >= 'A' && c <= 'Z'){
                if(c == 'Z'){
                    aucResult[i] = 'a';
                }else{
                    aucResult[i] = (char)(c+33);
                }
            }else if(c >= 'a' && c <= 'z'){
                if(c == 'z'){
                    aucResult[i] = 'A';
                }else{
                    aucResult[i] = (char)(c-31);
                }
            }else if(c >= '0' && c <= '9'){
                if(c == '9'){
                    aucResult[i] = '0';
                }else{
                    aucResult[i] = (char)(c+1);
                }
            }
        }
    }
    public static int unEncrypt(char[] result,char[] password){
        for(int i = 0; i < result.length; i++){
            char c = result[i];
            if(c >= 'A' && c <= 'Z'){
                if(c == 'A'){
                    password[i] = 'z';
                }else{
                    password[i] = (char)(c+31);
                }
            }else if(c >= 'a' && c <= 'z'){
                if(c == 'a'){
                    password[i] = 'Z';
                }else{
                    password[i] = (char)(c-33);
                }
            }else if(c >= '0' && c <= '9'){
                if(c == '0'){
                    password[i] = '9';
                }else{
                    password[i] = (char)(c-1);
                }
            }
        }
        return -1;
    }
}