import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            System.out.println(fun(num)+" "+fun(num*num));
//        }
        Candidate c = new Candidate();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i = 0;i < a;i++){
            c.AddCandidate(sc.nextLine().toCharArray());
        }
        int b = sc.nextInt();
        for(int i = 0;i < b;i++){
            c.VoteCandidate(sc.nextLine().toCharArray());
        }
        Set<Map.Entry<char[],Integer>> set = c.map.entrySet();
        Iterator<Map.Entry<char[],Integer>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<char[],Integer> map = iterator.next();
            System.out.println(map.getKey()+":"+map.getValue());
        }
    }
    public static int fun(int num){
        int sum = 0;
        while(num / 10 != 0){
            sum += num%10;
            num /= 10;
        }
        sum += num;
        return sum;
    }
}