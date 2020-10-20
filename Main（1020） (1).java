import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] array = new long[]{2,2,2,2,2};
        System.out.println(Arrays.toString(array));
        CutApart.cut(array);
        System.out.println(Arrays.toString(array));
        long[] array1 = BuildArray.构建随机数组();
        System.out.println(Arrays.toString(array1));
        TestDemo.Sort.quickSort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
