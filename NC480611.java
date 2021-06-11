public class NC48 {
    public static void main(String[] args) {
        //1,2,3,4,5,6,7,8,9   3
        //2,3,4,5,6,7,8,9,1   3
        //6,7,8,9,1,2,3,4,5   3


        //4,5,6,7,8,9,1,2,3 3
        int[] nums = new int[100000000];
//        Random random = new Random(40);
//        for(int i = 0 ;i < nums.length; i++){
//            nums[i] = random.nextInt();
//        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = i;
        }
        long startTime=System.currentTimeMillis();   //获取开始时间

        search(nums, 94429415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 11359415);
        search(nums, 9159415);

        long endTime=System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

        long start = System.currentTimeMillis();   //获取开始时间

        search(nums, 94429415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 84819415);
        search(nums, 11359415);
        search(nums, 9159415);

        long end = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： "+(end-start)+"ms");
//        System.out.println(search(nums, 94429415));

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 在旋转过的有序数组中寻找目标值
     * 给定一个整数数组nums，按升序排序，数组中的元素各不相同。
     *
     * nums数组在传递给search函数之前，会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，
     * 让数组变为[nums[t], nums[t+1], ..., nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
     * 比如，数组[0,2,4,6,8,10]在下标2处旋转之后变为[6,8,10,0,2,4]
     *
     * 现在给定一个旋转后的数组nums和一个整数target，请你查找这个数组是不是存在这个target，
     * 如果存在，那么返回它的下标，如果不存在，返回-1
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search (int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start + end)/2;
        while(start <= end){
            mid = (start+end)/2;
            if(nums[mid] >= nums[start] && nums[mid] <= nums[end]){
                if(nums[mid] > target){
                    end = mid-1;
                }else if(nums[mid] < target){
                    start = mid+1;
                }else{
                    return mid;
                }
            }else if(nums[mid] >= nums[start] && nums[mid] >= nums[end]){
                if(nums[mid] > target && nums[start] <= target){
                    end = mid-1;
                }else if(nums[mid] == target){
                    return mid;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid] <= nums[start] && nums[mid] <= nums[end]){
                if(nums[mid] < target && nums[end] >= target){
                    start = mid+1;
                }else if(nums[mid] == target){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }


    public static int fun(int[] arr,int num){
        for(int i = 0; i < arr.length; i++){
            if(num == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
