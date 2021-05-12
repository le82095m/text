import java.util.ArrayList;
import java.util.Comparator;

public class Nowcoder {
    /**
     *
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
     * 例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
     *
     * */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i = 0; i <= n; i++){
            count += numberOf1(i);
        }
        return count;
    }
    public int numberOf1(int num){
        int count = 0;
        while(num > 0){
            if(num % 10 == 1){
                count++;
            }
            num /= 10;
        }
        return count;
    }


    /**
     *
     * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
     * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
     * 
     * */


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k > input.length ||k <= 0){
            return list;
        }
        int i = 0;
        for(; i < k; i++){
            list.add(input[i]);
        }
        listSort(list);
        for(;i < input.length; i++){
            if(list.get(k-1) > input[i]){
                list.remove(k-1);
                list.add(input[i]);
                listSort(list);
            }
        }
        return list;
    }
    public void listSort(ArrayList list){
        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });
    }
}
