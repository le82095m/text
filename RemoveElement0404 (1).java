package leetCode;

public class RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int num = nums.length;
            int size = nums.length;
            int k = 0;
            while(k < nums.length){
                if(nums[k] == val){
                    num--;
                }
                k++;
            }
            if(num == 0){
                return num;
            }
            while(nums[size-1] == val){
                size--;
            }
            for(int i = 0;i < size-1;i++){
                while(nums[i] == val){
                    int j = i;
                    while(j < size-1){
                        nums[j] = nums[j+1];
                        j++;
                    }
                    size--;
                }
            }
            System.out.println(size);
            return size;
        }
    }
}
