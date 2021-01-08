package work;

public class Massage {
    public int massage(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.max(nums[i],nums[i+1]);
        }
    }
}
