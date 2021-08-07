package sort07;

import java.util.Arrays;
import java.util.Random;

public class Sort {
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

        margeSort(orderArray);
        margeSort(disorderArray);
        margeSort(sameArray);
        margeSort(randomArray);

        System.out.println("======================");
        System.out.println("排序后");
        System.out.println(Arrays.toString(orderArray));
        System.out.println(Arrays.toString(disorderArray));
        System.out.println(Arrays.toString(sameArray));
        System.out.println(Arrays.toString(randomArray));
        //最好:  最坏:  平均:
    }

    private static void margeSort(int[] array) {
        margeSortFunction(array,0,array.length);
    }

    //最好:O(n*log(n))  最坏:O(n*log(n))  平均:O(n*log(n))
    private static void margeSortFunction(int[] array, int low, int high) {
        if(low + 1 >= high){
            return;
        }

        int mid = (low + high)/2;
        margeSortFunction(array,low,mid);
        margeSortFunction(array,mid,high);
        marge(array,low,mid,high);
    }

    private static void marge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int[] newArray = new int[high - low];
        int index = 0;

        while (i < mid && j < high){
            if(array[i] <= array[j]){
                newArray[index++] = array[i++];
            }else{
                newArray[index++] = array[j++];
            }
        }

        while(i < mid){
            newArray[index++] = array[i++];
        }

        while(j < high){
            newArray[index++] = array[j++];
        }

        index = 0;
        for(int k = low; k < high; k++){
            array[k] = newArray[index++];
        }
    }

    private static void quickSort(int[] array) {
        quickSortFunction(array,0,array.length-1);
    }

    //最好:O(n*log(n))  最坏:O(n)^2  平均:O(n*log(n))
    private static void quickSortFunction(int[] array, int left, int right) {
        if(left >= right){
            return;
        }

        int index = partition(array,left,right);
        quickSortFunction(array,left,index-1);
        quickSortFunction(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;

        while(i < j){
            while(i < j && array[j] >= array[left]){
                j--;
            }
            while(i < j && array[i] <= array[left]){
                i++;
            }
            swap(array,i,j);
        }
        swap(array,i,left);
        return i;
    }

    //最好:O(n)  最坏:O(n)^2  平均:O(n)^2
    private static void bubbleSort(int[] array) {
        boolean isSort = true;
        for(int i = array.length-1; i >= 0; i--){
            for(int j = 0; j < i ; j++){
                if(array[j+1] < array[j]){
                    swap(array,j,j+1);
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }

    //最好:O(n*log(n))  最坏:O(n*log(n))   平均:O(n*log(n))
    private static void heapSort(int[] array) {
        buildHeap(array,array.length);//O(log(n))
        for(int i = array.length - 1; i >= 0; i--){//O(n)
            swap(array,i,0);
            shift(array,i,0);//O(log(n))
        }
    }

    private static void shift(int[] array, int size, int index) {
        int left = index + 1;
        while(left < size){
            int right = left + 1;
            int max = left;

            if(right < size){
                max = array[left] >array[right] ? left : right;
            }

            if(array[max] < array[index]){
                break;
            }

            swap(array,index,max);
            index = max;
            left = index * 2 + 1;
        }
    }

    private static void buildHeap(int[] array, int size) {
        for(int i = (size-1-1)/2; i >= 0; i--){
            shift(array,size,i);
        }
    }

    //最好:O(n)^2  最坏:O(n)^2  平均:O(n)^2
    private static void selectSort(int[] array) {
        for(int i = array.length - 1; i >= 0; i--){
            int max = i;
            for(int j = 0; j < i; j++){
                if(array[j] > array[max]){
                    max = j;
                }
            }
            swap(array,max,i);
        }
    }

    private static void swap(int[] array, int j, int i) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //最好:O(n)  最坏:O(n)^2  平均:O(n)^1.3
    private static void shellSort(int[] array) {
        int len = array.length;
        while(len > 1){
            shellSortFunction(array,len);
            len = len / 3 - 1;
        }
        shellSortFunction(array,1);
    }

    private static void shellSortFunction(int[] array, int len) {
        for(int i = 1; i < array.length; i++){
            int val = array[i];
            int j = i - len;
            for(; j >= 0; j-=len){
                if(array[j] > val){
                    array[j+len] = array[j];
                }else{
                    break;
                }
            }
            array[j+len] = val;
        }
    }

    //最好:O(n)  最坏:O(n)^2  平均:O(n)^2
    private static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int val = array[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(array[j] > val){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = val;
        }
    }
}
