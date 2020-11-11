package work;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = -2147483648;
        if(nums.length == 0){
            return max;
        }
        for(int i = 0; i < nums.length;i++){
            int count = 0;
            int sum = 0;
            while(i+count < nums.length){
                sum +=nums[i+count];
                max = Math.max(max,sum);
                count++;
            }
        }
        return max;
    }
}
