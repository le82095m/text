package Work;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,2,3,4,5,5,5,5,6,7,7,7,7};
        s.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
