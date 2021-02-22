import java.util.Arrays;
import java.util.Random;

public class BuildArray {
    public static int[] 建立随机数组(){
        Random random = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    public static int[] 建立顺序数组(){
        int[] arr = 建立随机数组();
        Arrays.sort(arr);
        return arr;
    }
    public static int[] 建立逆序数组(){
        int[] arr = 建立顺序数组();
        swap(arr,0,9);
        swap(arr,1,8);
        swap(arr,2,7);
        swap(arr,3,6);
        swap(arr,4,5);
        return arr;
    }
    public static int[] 建立相等数组(){
        int[] arr = new int[]{5,5,5,5,5,5,5,5,5,5};
        return arr;
    }
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
