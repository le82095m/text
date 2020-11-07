package leetCode;

import java.util.Arrays;

class Solution {
    //遍历一遍数组，当元素相同时，该下标后的所有元素前移一位
    public int removeDuplicates(int[] nums) {
        Math.min(1,2);
        //{1,1,1,1}
        int size = nums.length;
        for(int i = 0 ; i < size-1 ; i++){
            if(nums[i] == nums[i+1]){
                int index = i;
                int count = 1;
                size--;
                while(index+count < size && nums[index+1] == nums[index+count+1]){
                    count++;
                }
                size -= count-1;
                while(index + count < nums.length){
                    nums[index] = nums[index+count];
                    index++;
                }
            }
        }
        System.out.println(size);
        System.out.println(Arrays.toString(nums));
        return size;
    }
}
