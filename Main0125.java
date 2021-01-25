import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int size = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1;i <= num;i++){
            map.put(i,sc.nextInt());
        }
//        System.out.println(query(sc.nextInt(),sc.nextInt(),map));
//        update(sc.nextInt(),sc.nextInt(),map);
//        System.out.println(query(sc.nextInt(),sc.nextInt(),map));
        for(int i = 0;i < size;i++){
            char c = sc.next().charAt(0);
            if(c == 'Q'){
                System.out.println(query(sc.nextInt(),sc.nextInt(),map));
            }
            if(c == 'U'){
                update(sc.nextInt(),sc.nextInt(),map);
            }
        }
    }
    public static int query(int start,int end,HashMap<Integer,Integer> map){
        int max = 0;
        for(int i = start;i <= end;i++){
            max = Math.max(max,map.getOrDefault(i,0));
        }
        return max;
    }
    public static void update(int id,int score,HashMap<Integer,Integer> map){
        map.put(id,score);
    }
}