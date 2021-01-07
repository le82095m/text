import java.util.*;


class Solution {
    /**
     *
     * @param A int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    //7  8  0  1  2  3  4  5  6
    public int search (int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        for (:
             ) {
            
        }
        while(start <= end){
            int mid = (start+end)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] < A[end]){
                if(A[mid] < target && A[end] >= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(A[mid] > target && A[start] <= target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}