import java.util.*;
public class solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < num.length-2; i++){
            for(int j = i+1; j < num.length-1; j++){
                for(int k = j+1; k < num.length; k++){
                    if(num[i]+num[j]+num[k] == 0){
                        list.add(fun(num[i],num[j],num[k]));
                    }
                }
            }
        }
        return list;
    }
    public static ArrayList<Integer> fun(int a,int b,int c){
        int max = Math.max(Math.max(a,b),c);
        int min = Math.min(Math.min(a,b),c);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(min);
        if(a < max && a > min){
            list.add(a);
        }else if(b < max && b > min){
            list.add(b);
        }else if(c < max && c > min){
            list.add(c);
        }else{
            list.add(c);
        }
        list.add(max);
        return list;
    }
}