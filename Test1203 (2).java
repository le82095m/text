import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        int[] A = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] B = t.multiply(A);
        System.out.println(Arrays.toString(B));
    }
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i-1]*A[i-1];
        }
        int temp = 1;
        for(int j = A.length-2;j >= 0;j--){
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}
