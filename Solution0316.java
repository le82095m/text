import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            dfs(1, n, 0, m);
            for (ArrayList<Integer> lists : arrayLists) {
                int count = lists.size();
                for (Integer i : lists) {
                    System.out.println(i);
                    if (count > 0) {
                        System.out.println(" ");
                    }
                    count--;
                }
                System.out.println("");
            }
            for (ArrayList<Integer> l : arrayLists){
                l.clear();
            }
            arrayLists.clear();
        }
    }
    private static void dfs(int startIndex,int n,int sum,int m){
        if(sum >= m){
            if(sum == m){
                arrayLists.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = startIndex; i <= n; i++){
            if(i > m){
                continue;
            }
            list.add(i);
            dfs(i+1,n,sum+i,m);
            list.remove(list.size()-1);
        }
    }
}
