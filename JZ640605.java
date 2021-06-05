package nowcoder;

import java.util.ArrayList;

public class JZ64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(size > num.length || size <= 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = size;
        int max = maxNum(num,start,end);
        list.add(max);
        start++;
        end++;
        while(end <= num.length){
            if(max == num[start-1]){
                max = maxNum(num,start,end);
            }else{
                if(max < num[end-1]){
                    max = num[end-1];
                }
            }
            list.add(max);
            start++;
            end++;
        }
        return list;
    }
    public int maxNum(int[] num,int start,int end){
        int max = num[start];
        for(int i = start; i < end; i++){
            max = max>num[i]?max:num[i];
        }
        return max;
    }
}
