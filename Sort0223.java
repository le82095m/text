public class Sort {
    //插入排序
    public static void insertSort(int[] arr) {
        // {有序,无序}
        // {4,5,6,8,7,3,5,6,9,2,1}
        // 无序数组[i+1,arr.length]
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            //有序数组[0,i]
            //插入的过程
            for (j = i - 1; j >= 0; j--) {
                if (key < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        //{无序,有序}
        //无序数组[0,arr.length-1-i]
        //有序数组[arr.length-i,arr.length)
        boolean is有序 = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    BuildArray.swap(arr, j, j + 1);
                    is有序 = false;
                }
            }
            if (is有序) {
                break;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
        //{无序,有序}
        //无序数组[0,arr.length-1-i]
        //有序数组[arr.length-i,arr.length)
        //[80, 18, 18, 43, 14, 35, 78, 81, 78, 94]
        for (int i = 0; i < arr.length - 1; i++) {
            int index = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
            }
            BuildArray.swap(arr, arr.length - 1 - i, index);
        }
    }

    //堆排序
    public static void dequeSort(int[] arr) {
        //{无序，有序}
        //无序数组[0,arr.length-1-i]
        //有序素组(arr.length-1-i,arr.length)
        buildDeque(arr, arr.length);
        for (int i = arr.length; i > 0; i--) {
            BuildArray.swap(arr, 0, i - 1);
            downAdjust(arr, i - 1, 0);
        }
    }

    //向下调整
    public static void downAdjust(int[] arr, int size, int index) {
        int left = index * 2 + 1;
        if (left > size - 1) {
            return;
        }
        if (left == size - 1) {
            if (arr[left] > arr[index]) {
                BuildArray.swap(arr, index, left);
            }
            return;
        }
        while (left < size - 1) {
            if (arr[left] > arr[index] && arr[left] > arr[left + 1]) {
                BuildArray.swap(arr, index, left);
                index = left;
            } else if (arr[left + 1] > arr[index] && arr[left + 1] > arr[left]) {
                BuildArray.swap(arr, index, left + 1);
                index = left + 1;
            } else {
                break;
            }
            left = index * 2 + 1;
        }
    }

    //建大堆
    public static void buildDeque(int[] arr, int size) {
        for (int i = ((size - 1) - 1) / 2; i >= 0; i--) {
            downAdjust(arr, size, i);
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 0){
            insert(arr,gap);
            gap = (gap/3)-1;
        }
        insert(arr,1);
    }
    public static void insert(int[] arr,int gap){
        for(int i = 0; i < arr.length; i++){
            int key = arr[i];
            int j = i-gap;
            for(; j >= 0; j-=gap){
                if(arr[j] > key){
                    arr[j+gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap] = key;
        }
    }


}
