import java.util.Scanner;

public class Test2 {
    static int[] arr = new int[40];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(backpack(40, n));
    }

    private static int backpack(int a, int n) {
        if(a == 0){
            return 1;
        }
        if(n <= 0){
            return 0;
        }
        return backpack(a,n-1)+backpack(a-arr[n-1],n-1);
    }
}
