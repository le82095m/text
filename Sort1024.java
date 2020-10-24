package SelectSort;

public class Sort {
    public static void selectSort(long[] arr){
        for (int i = arr.length-1; i > 0; i--) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            swap(arr,max,i);
        }
    }

    private static void swap(long[] arr, int max, int i) {
        long t = arr[max];
        arr [max] = arr[i];
        arr[i] = t;
    }
}
