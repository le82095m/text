package nowcoder;

public class NC105 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 如果目标值存在返回下标，否则返回 -1
         * @param nums int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public int search (int[] nums, int target) {
            //[-2,1,2],2
            int start = 0;
            int end = nums.length-1;
            int mid = (start + end)/2;
            while(start <= end){
                mid = (start + end)/2;
                if(target < nums[mid]){
                    end = mid-1;
                }else if(target > nums[mid]){
                    start = mid+1;
                }else{
                    break;
                }
            }
            if(start <= end){
                while(mid > 0){
                    if(nums[mid-1] == nums[mid]){
                        mid--;
                    }else{
                        break;
                    }
                }
                return mid;
            }else{
                return -1;
            }
        }
}
