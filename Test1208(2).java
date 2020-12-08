import java.util.*;
 class Main{
    public static void main(String args[]){
        int[] arr = new int[50];
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNext()){
            arr[i] = sc.nextInt();
            i++;
        }
        Arrays.sort(arr);
        StringBuilder str = new StringBuilder();
        if(arr[0]==0){
            int j = 0;
            for( j = 0;j < arr.length;j++){
                if(arr[j] != 0){
                    str.append(arr[j]);
                    break;
                }
            }
            for(int k = 0;k < arr.length;k++){
                if(k != j){
                    str.append(arr[k]);
                }
            }
        }
        System.out.println(str);
    }
}