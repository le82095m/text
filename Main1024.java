package SelectSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] arr = CreateArray.createEqualArray();
        System.out.println(Arrays.toString(arr));
        Sort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
