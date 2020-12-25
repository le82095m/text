package Work;

class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(nums[size-1] == nums[size-2] && nums[size-2] == nums[size-3]){
            size++;
        }
        for(int i = 0 ; i < size-1 ; i++){
            if(nums[i] == nums[i+1]){
                int index = i;
                int count = 1;
                while(index + count < nums.length && nums[index] == nums[index+count]){
                        count++;
                }
                count--;
                while(index + count < nums.length){
                    nums[index] = nums[index+count];
                    index++;
                }
            }
        }
        System.out.println(size);
        return size;
    }
}
