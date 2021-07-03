package solution;

import java.util.Arrays;
import java.util.Comparator;

public class NC18 {
    public static void main(String[] args) {
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
    public int[][] rotateMatrix(int[][] mat, int n) {
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = mat[n-1-j][i];
            }
        }
        return arr;
    }
}
