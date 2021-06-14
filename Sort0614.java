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

        selectSort(orderArray);
        selectSort(disorderArray);
        selectSort(sameArray);
        selectSort(randomArray);
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
            swap(arr,i,0);
//            shiftDown(arr,arr.length,0);
        }
    }
    private static void buildHeap(int[] arr){
        int index = (arr.length-1-1)/2;
        for(int i = index; i >= 0; i--){
//            shiftDown(arr,arr.length,i);
        }
    }
    private static void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
//    private static void shiftDown(int[] arr,int size,int index){]
//
//    }
}
