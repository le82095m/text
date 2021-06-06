package nowcoder;

import java.util.*;
class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            nums[i] = sc.nextInt();
        }
        int[] values = new int[size];
        for(int i= 0;i < size; i++){
            values[i] = sc.nextInt();
        }
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            ArrayList<Integer> list = map.computeIfAbsent(nums[i], k -> new ArrayList<>());
            list.add(i);
        }
        System.out.println(minFun(nums,values,map));
    }
    public static int minFun(int[] nums,int[] values,Map<Integer,ArrayList<Integer>> map){
        int sum = 0;
        while(true){
            boolean is = true;
            for(int num : map.keySet()){
                ArrayList<Integer> list = map.get(num);
                if(list.size() == 1){
                    continue;
                }else{
                    is = false;
                }
                int index = 0;
                int size = list.size();
                int min = list.get(0);
                for(int i = 0; i < size; i++){
                    int n = list.get(0);
                    if(values[n] < min){
                        min = n;
                    }
                    list.remove(0);
                    nums[n]++;
//                    ArrayList<Integer> arrayList = map.get(nums[n]);
//                    if(arrayList == null){
//                        list = new ArrayList<>();
//                        map.put(nums[i]+1,list);
//                    }
//                    arrayList.add(nums[n]);
//                    sum += values[i];
                }
            }
            if(is){
                return sum;
            }
        }
    }
}
