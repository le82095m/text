public class TestDemo {
     static class Sort {
         public static void quickSort(long[] array) {
             quickSortInternal(array, 0, array.length - 1);
         }

         // 区间是 [lowIndex, highIndex]
         private static void quickSortInternal(long[] array,
                                               int lowIndex,
                                               int highIndex) {
             // 由于是闭区间，所以，区间内个个数需要加个 1
             int size = highIndex - lowIndex + 1;
             if (size <= 1) {
                 return;
             }

             // 选择其中一个数（选最左边的） —— array[lowIndex]
             // 执行 partition，小的放左，大的放右
             // keyIndex 是经过 partition 之后，选出来的数最终所在下标
             int keyIndex = partition1(array, lowIndex, highIndex);
             // 分别对左右区间进行相同的处理 —— 递归方法
             quickSortInternal(array, lowIndex, keyIndex - 1);
             quickSortInternal(array, keyIndex + 1, highIndex);
         }

//         private static int partitionPit(long[] array, int lowIndex, int highIndex) {
//             int index = 0;
//             long num = array[lowIndex];
//             for (int i = lowIndex; i <= highIndex; i++){
//                 if(array[i] > num){
//                     array[index] = array[i];
//                     index = i;
//                 }
//             }
//             array[index] = num;
//             return index;
//         }

         private static int partition(long[] array, int lowIndex, int highIndex) {
             long num = array[lowIndex];
             for (int i = lowIndex; i < highIndex; i++) {
                 if (array[i] > num) {
                     if (highIndex + 1 - i >= 0) System.arraycopy(array, i, array, i + 1, highIndex + 1 - i);
                     array[highIndex + 1] = array[i];
                 }
             }
             int k;
             for (k = 0; k < array.length; k++) {
                 if (array[k] == num) {
                     break;
                 }
             }
             return k;
         }

         private static int partition1(long[] array, int lowIndex, int highIndex) {
             long num = array[lowIndex];
             int leftIndex = lowIndex;
             int rightIndex = highIndex;
             while (leftIndex < rightIndex){
                 while (leftIndex < rightIndex && array[leftIndex] <= num){
                     leftIndex++;
                 }
                 while ((leftIndex < rightIndex && array[rightIndex] >=  num)){
                     rightIndex--;
                 }
                 swap(array,rightIndex,leftIndex);
             }
             swap(array,rightIndex,lowIndex);
             return leftIndex;
         }

         private static void swap(long[] arr, int leftIndex, int rightIndex) {
             long t = arr[leftIndex];
             arr[leftIndex] = arr[rightIndex];
             arr[rightIndex] = t;
         }

     }
}
