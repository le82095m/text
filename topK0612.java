import java.util.Comparator;
import java.util.PriorityQueue;

public class topK{
    public static void main(String[] args) {
        System.out.println(topK(new int[]{5,3,4,8,7,6,1,2,9},3));
        System.out.println(topK(new int[]{},3));
        System.out.println(topK(new int[]{5,3,4,8,7,6,1,2,9},11));
        System.out.println(topK(new int[]{5,3,4,8,7,6,1,2,9},-1));
    }
    public static String topK(int[] nums,int k){
        if(k <= 0 || nums.length == 0){
            return "[]";
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                pq.offer(nums[i]);
            }else{
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.toString();
    }
}