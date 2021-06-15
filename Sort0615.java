import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int size = 10;
        int[] orderArray = buildOrderArray(size);
        int[] disorderArray = buildDisorderArray(size);
        int[] randomArray = buildRandomArray(size);
        int[] sameArray = buildSameArray(size);
        System.out.println("排序前");
        System.out.println(Arrays.toString(orderArray));
        System.out.println(Arrays.toString(disorderArray));
        System.out.println(Arrays.toString(sameArray));
        System.out.println(Arrays.toString(randomArray));

        mergeSort(orderArray);
        mergeSort(disorderArray);
        mergeSort(sameArray);
        mergeSort(randomArray);
        System.out.println("======================");
        System.out.println("排序后");
        System.out.println(Arrays.toString(orderArray));
        System.out.println(Arrays.toString(disorderArray));
        System.out.println(Arrays.toString(sameArray));
        System.out.println(Arrays.toString(randomArray));
    }

    private static int[] buildRandomArray(int size) {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 9; i >= 0; i--) {
            nums[i] = random.nextInt(100);
        }
        return nums;
    }

    private static int[] buildSameArray(int size) {
        int[] nums = new int[10];
        for (int i = 9; i >= 0; i--) {
            nums[i] = 5;
        }
        return nums;
    }

    private static int[] buildDisorderArray(int size) {
        int[] nums = new int[10];
        for (int i = 9; i >= 0; i--) {
            nums[i] = i;
        }
        return nums;
    }

    private static int[] buildOrderArray(int size) {
        int[] nums = new int[10];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
        return nums;
    }

    //1 5 4 8 7 6 9 3 2

    //初始时：
    //无序区间：[0,1)
    //有序区间：[1,arr.length-1]
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int val = arr[i];
            //无序区间中的第一个元素
            int j;
            for(j = i-1; j >= 0 && arr[j] > val; j--){
                //有序区间从后向前遍历
                arr[j+1] = arr[j];
                //有序区间中遍历到的该元素a[j]>判断值val,则该元素在数组中的位置向后移一位
            }
            arr[j+1] = val;
        }
    }


    public static void shellSort(int[] arr){
        int len = arr.length;
        while(len > 1){
            gapInsertSort(arr,len);
            len = (len / 3) + 1;
        }
        gapInsertSort(arr,1);
    }
    private static void gapInsertSort(int[] arr,int len){
        for(int i = 1; i < arr.length; i++){
            int val = arr[i];
            int j = i-len;
            for(; j >= 0 && arr[j] > val; j-=len){
                arr[j+len] = arr[j];
            }
            arr[j+len] = val;
        }
    }
//    public static void selectSort(int[] arr){
//        for(int i = 0; i < arr.length; i++){
//            int index = i;
//            for(int j = i; j < arr.length-1; j++){
//                if(arr[j+1] < arr[index]){
//                    index = j+1;
//                }
//            }
//            int t = arr[i];
//            arr[i] = arr[index];
//            arr[index] = t;
//        }
//    }
    public static void selectSort(int[] arr){
        //无序区间[0,array.length)
        //有序区间(array.length,array.length)
        for(int i = arr.length; i > 0; i--){
            int j = 0;
            int index = 0;
            for(; j < i; j++){
                if(arr[j] > arr[index]){
                    index = j;
                }
            }
            int t = arr[index];
            arr[index] = arr[i-1];
            arr[i-1] = t;
        }
    }
    public static void heapSort(int[] arr){
        buildHeap(arr);
        for(int i = arr.length-1; i >= 0; i--){
            //交换前
            //无序数组[0,i]
            //有序数组(i,arr.length)
            swap(arr,i,0);
            shiftDown(arr,i,0);
            //交换后
            //无序数组[0,i-1]
            //有序数组(i-1,arr.length)
            //无序数组长度：i
        }
    }
    //建堆
    private static void buildHeap(int[] arr){
        int index = (arr.length-1-1)/2;
        for(int i = index; i >= 0; i--){
            shiftDown(arr,arr.length,i);
        }
    }
    //交换数组两元素
    private static void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    //堆向下调整
    private static void shiftDown(int[] arr,int size,int index){
        int left = index * 2 + 1;
        while(left < size){
            int max = left;
            int right = left+1;
            if(right < size){
                if(arr[right] > arr[max]){
                    max = right;
                }
            }

            if(arr[index] >= arr[max]){
                break;
            }
            swap(arr,index,max);

            index = max;
            left = index * 2 + 1;
        }
    }
    public static void bubbleSort(int[] arr){
        for(int i = arr.length-1; i >= 0; i--){
            boolean isSort = true;
            //无序数组：[0,i)
            //有序数组：[i,arr.length)
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    isSort = false;
                }
            }
            if(isSort){
                break;
                //优化，如果无序区间遍历一次未有元素进行交换，则表明有序
            }
        }
    }
    public static void quickSort(int[] arr){
        quickSortFunction(arr,0,arr.length-1);
    }
    private static void quickSortFunction(int[] arr,int start,int end){
        if(start == end){
            return;
        }
        if(start > end){
            return;
        }
        //为方便起见，每次将index起始位置定为start
        int index = partition(arr,start,end);
        quickSortFunction(arr,start,index-1);
        //index 之前的都是比 基准值 小的
        quickSortFunction(arr,index+1,end);
        //index 之前的都是比 基准值 大的
    }

    private static int partition(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while (left < right){
            while (left < right && arr[left] <= arr[start]){
                left++;
            }
            while (left < right && arr[right] >= arr[start]){
                right--;
            }
            swap(arr,left,right);
        }
        swap(arr,start,right);
        return right;
    }

    private static int partition1(int[] arr,int start,int end){
        int left = start;
        int right = end;
        int val = arr[start];
        while (left < right){
            while (left < right && arr[left] <= val){
                left++;
            }
            arr[right] = arr[left];
            while (left < right && arr[right] >= val){
                right--;
            }
            arr[left] = arr[right];
        }
        arr[left-1] = val;
        return left-1;
    }

    public static void mergeSort(int[] arr){
        mergeSortFunction(arr,0,arr.length);
        //待排序区间[0,arr.length)
    }

    private static void mergeSortFunction(int[] arr, int low, int high) {
        if(high - low <= 1){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortFunction(arr,low,mid);
        mergeSortFunction(arr,mid,high);

        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int len = high-low;
        int[] newArray = new int[len];
        int k = 0;
        while(i < mid && j < high){
            if(arr[i] < arr[j]){
                newArray[k++] = arr[i++];
            }else{
                newArray[k++] = arr[j++];
            }
        }
        while (i < mid){
            newArray[k++] = arr[i++];
        }
        while (j < high){
            newArray[k++] = arr[j++];
        }
        for(k = 0; k < len; k++){
            arr[low+k] = newArray[k];
        }
    }
}
