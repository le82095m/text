package SelectSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class CreateArray {
    public static long[] createRandomArray(){
        Random random = new Random(20201024);
        long[] arr = new long[10];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static long[] createOrderedArray(){
        long[] arr = createRandomArray();
        Arrays.sort(arr);
        return arr;
    }

    public static long[] createReversArray(){
        long[] arr = createOrderedArray();
        for (int i = 0; i < (arr.length-1)/2; i++) {
            swap(arr,i,arr.length-1-i);
        }
        return arr;
    }

    public static long[] createEqualArray(){
        long[] arr = new long[10];
        Arrays.fill(arr, 10);
        return arr;
    }

    private static void swap(long[] arr, int a, int b) {
        long t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}