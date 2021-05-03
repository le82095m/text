//1 2 3 4 5
//2 3 4 5 1
//3 4 5 6 2
//4 5 1 2 3
//5 1 2 3 4
 class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minNumberInRotateArray(new int[]{3,4,5,6,7,8
                }));
    }
    public int minNumberInRotateArray(int [] array) {
        int start = 0;
        int end = array.length-1;
        int mid = (start + end) / 2;
        int min = array[end];
        while(start < end){
            mid = (start + end) / 2;
            if(array[start] < array[mid]){
                if(array[start] < min){
                    min = array[start];
                }
                start = mid;
            }else{
                if(array[mid] < min){
                    min = array[mid];
                }
                end = mid;
            }
        }
        return min;
    }
}
