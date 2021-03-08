import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int size = 0;
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        while(sc.hasNext()){
            int aor = sc.nextInt();
            int num = sc.nextInt();
            if(aor == 1){
                list.add(num);
                size += num;
            }else{
                if(list.contains(num)) {
                    list.remove((Integer) num);
                    size -= num;
                }
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            boolean tof = judge(list,size);
            if(tof){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean judge(List<Integer> list,int size) {
        if(list.size() == 0){
            return false;
        }
        return size - list.get(0) > list.get(0);
    }
}
