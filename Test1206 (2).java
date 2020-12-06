import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();
        for(int i = 0;i < (n+1)/2;i++){
            for(int j = 0;j < n;j++){
                print(c);
            }
            println("");
        }
    }
}
