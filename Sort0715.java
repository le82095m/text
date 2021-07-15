package sort15;

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

    private static void selectSort(int[] array) {
        for(int i = array.length-1; i >= 0; i--){
            int min = i;
            for(int j = 0; j <= i;j++){
                if(array[j] > array[min]){
                    min = j;
                }
            }
            swap(array,min,i);
        }
    }

    private static void swap(int[] array, int min, int i) {
        int t = array[min];
        array[min] = array[i];
        array[i] = t;
    }

    private static void shellSort(int[] array) {
        int len = array.length;
        while(len > 1){
            function(array,len);
            len = len / 3 + 1;
        }
        function(array,1);
    }

    private static void function(int[] array, int len) {
        for(int i = 1; i < array.length; i++){
            int val = array[i];
            int j = i - len;
            for(;j >=0;j -= len){
                if(array[j] > val){
                    array[j+len] = array[j];
                }else{
                    break;
                }
            }
            array[j+len] = val;
        }
    }

    private static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int val = array[i];
            int j = i-1;
            for(;j >= 0; j--){
                if(array[j] > val){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = val;
        }
    }

    private static int[] buildRandomArray(int size) {
        long time = System.currentTimeMillis();
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
}
