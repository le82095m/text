import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int num = fun(str.toCharArray());
            System.out.println(num);
        }
    }
    public static int fun(char[] arr){
        int startIndex = 0;
        int size = 0;
        int index = 0;
        int i = 0;
        for(; i < arr.length-1;i++){
            if(arr[i+1] == arr[i]){
                if(size < i+1 - startIndex){
                    size = i+1 - startIndex;
                }
                startIndex = i+1;
            }
        }
        if(size < arr.length - startIndex){
            size = arr.length - startIndex;
        }
        return size;
    }
}