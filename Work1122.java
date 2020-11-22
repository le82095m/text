class Solution {
        /**
         * 二分查找
         * @param n int整型 数组长度
         * @param v int整型 查找值
         * @param a int整型一维数组 有序数组
         * @return int整型
         * 请实现有重复数字的有序数组的二分查找。
         * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
         */
        public int upper_bound_ (int n, int v, int[] a) {
            if(v > a[n-1]){
                return n+1;
            }
            int startIndex = 0;
            int endIndex = a.length-1;
            int mid = (startIndex + endIndex)/2;
            while(startIndex < endIndex){
                if(a[mid] < v){
                    startIndex = mid+1;
                    mid = (startIndex + endIndex)/2;
                }else if(mid > 1 && a[mid-1] < v){
                    return mid+1;
                }else{
                    endIndex = mid-1;
                    mid = (startIndex + endIndex)/2;
                }
            }
            return mid+1;
        }
    }
