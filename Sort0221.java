public class Sort {
    public static void insertSort(int[] arr){
        //{5,6,4,8,7,3,5,6,9,2,1}
        //无序数组[i+1,arr.length]
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j;
            //有序数组[0,i]
            for(j = i-1; j >= 0; j--){
                if(key < arr[j]){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }
}
