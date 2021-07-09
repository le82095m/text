package sort09;

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
        bubbleSort(orderArray);
        bubbleSort(disorderArray);
        bubbleSort(sameArray);
        bubbleSort(randomArray);

        System.out.println("======================");
        System.out.println("排序后");
        System.out.println(Arrays.toString(orderArray));
        System.out.println(Arrays.toString(disorderArray));
        System.out.println(Arrays.toString(sameArray));
        System.out.println(Arrays.toString(randomArray));
    }

    private static void bubbleSort(int[] array) {
        boolean is = true;
        for(int i = array.length-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(array[j] > array[j+1]) {
                    swap(array, j, j + 1);
                    is = false;
                }
            }
            if(is){
                return;
            }
        }
    }

    private static void heapSort(int[] array) {
        buildHeap(array,array.length);
        for(int i = array.length-1; i >= 0; i--){
            swap(array,i,0);
            shiftDown(array,i,0);
        }
    }

    private static void buildHeap(int[] array, int size) {
        for(int i = (size-1-1)/2; i >= 0; i--){
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int left = index * 2 + 1;
        while (left < size){
            int right = left+1;
            int min = left;
            if(right < size){
                min = array[left] > array[right] ? left : right;
            }
            if(array[min] > array[index]){
                swap(array,index,min);
                index = min;
                left = index * 2 + 1;
            }else{
                break;
            }
        }
    }

    private static void selectSort(int[] array) {
        for(int i = array.length-1; i >= 0; i--){
            int j = 0;
            int min = 0;
            for(;j <= i;j++){
                if(array[j] > array[min]){
                    min = j;
                }
            }
            swap(array,min,i);
        }
    }

    private static void swap(int[] array, int min, int i) {
        int t = array[i];
        array[i] = array[min];
        array[min] = t;
    }

    private static void shellSort(int[] array) {
        int len = array.length;
        while(len > 1){
            function(array,len);
            len = len/3 - 1;
        }
        function(array,1);
    }

    private static void function(int[] array, int len) {
        for(int i = 1; i < array.length; i++){
            int j = i - len;
            int val = array[i];
            for(; j >= 0; j -= len) {
                if (array[j] > val) {
                    array[j + len] = array[j];
                }else {
                    break;
                }
            }
            array[j + len] = val;
        }
    }

    private static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            int val = array[i];
            for(;j >= 0; j--) {
                if (array[j] > val) {
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = val;
        }
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
}
