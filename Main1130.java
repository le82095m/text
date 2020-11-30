//|   |   | x |   |   |
//|   | x |   | x |   |
//| x |   | 8 |   | x |  2 2
//|   | x |   | x |   |  1 3
//|   |   | x |   |   |
//    [0, 0, 1, 1, 0, 0]
//    [0, 1, 1, 1, 1, 0]
//    [1, 1, 0, 0, 1, 1]
//    [0, 1, 1, 1, 1, 0]
//    [0, 0, 1, 1, 0, 0]
//    [0, 0, 0, 0, 0, 0]
//    [0, 0, 0, 0, 0, 0]
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int l = sc.nextInt();
        int[][] arr = new int[r + 4][l + 4];
        for (int i = 2; i < r + 2; i++) {
            for (int j = 2; j < l + 2; j++) {
                if(arr[i][j] !=1) {
//                    arr[i - 1][j - 1] = 1;
//                    arr[i + 1][j + 1] = 1;
//                    arr[i - 1][j + 1] = 1;
//                    arr[i + 1][j - 1] = 1;
                    arr[i][j - 2] = 1;
                    arr[i][j + 2] = 1;
                    arr[i - 2][j] = 1;
                    arr[i + 2][j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < r + 2; i++) {
            for (int j = 2; j < l + 2; j++) {
                if(arr[i][j] != 1){
                    count++;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(count);
    }
}