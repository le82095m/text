package nowcoder;

import java.util.*;
class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
        int[] nums = new int[]{1,1,2};
        int[] values = new int[]{4,5,3};
//        for(int i = 0; i < size; i++){
//            nums[i] = sc.nextInt();
//        }
//        for(int i= 0;i < size; i++){
//            values[i] = sc.nextInt();
//        }
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        // key = nums[i]的值
        // value = 各个相同nums[i]组成的ArrayList
        for(int i = 0; i < 3; i++){
            ArrayList<Integer> list = map.computeIfAbsent(nums[i], k -> new ArrayList<>());
            list.add(i);
            //List中存放nums[i]相同的下标i
        }
        System.out.println(minFun(nums,values,map));
    }
    public static int minFun(int[] nums,int[] values,Map<Integer,ArrayList<Integer>> map){
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int num : nums){
            queue.add(num);
        }
        int j = 0;
        int m = 0;
        int a = 1;
        while(true){
            int num = queue.remove();
            queue.add(num);
            ArrayList<Integer> list = map.get(num);
            if(list.size() == 1){
                m++;
            }
            j++;
            int index = list.get(0);
            int size = list.size();
            if(size > 1) {
                int max = values[list.get(0)];
                for (int i = 0; i < size; i++) {
                    int n = list.get(0);
                    if (values[n] > max) {
                        max = values[n];
                        index = n;
                    }
                    list.remove(0);
                    nums[n]++;
                    sum += values[n];
                    ArrayList<Integer> arrayList = map.computeIfAbsent(nums[n], k -> new ArrayList<>());
                    arrayList.add(index);
                }
                ArrayList<Integer> arrayList = map.get(nums[index]);
                arrayList.remove((Integer) index);
                nums[index]--;
                sum -= values[index];
                ArrayList<Integer> List = map.computeIfAbsent(nums[index], k -> new ArrayList<>());
                List.add(index);
            }
            if(j == 3 && m == 3){
                return sum;
            }else if(j == 3){
                j = 0;
                m = 0;
            }
            queue.clear();
            for(int numA : nums){
                queue.add(numA);
            }
            for(int i = 0; i < a; i++) {
                int numB = queue.remove();
                queue.add(numB);
            }
            if(a < 3){
                a++;
            }else{
                a = 0;
            }
        }
    }
}
