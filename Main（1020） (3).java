public class CutApart {
    public static void cut(long[] arr){
        if(arr == null){
            return;
        }
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && arr[leftIndex] %2 != 0){
                leftIndex++;
            }
            while (leftIndex < rightIndex && arr[rightIndex] %2 ==0){
                rightIndex--;
            }
            swap(arr,leftIndex,rightIndex);
        }
    }

    private static void swap(long[] arr, int leftIndex, int rightIndex) {
        long t = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = t;
    }
}
