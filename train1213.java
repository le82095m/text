import java.util.*;
//1、穷举出所有出站的顺序
//2、判断筛选出这些顺序中合法的顺序
//3、按照首元素的字典序进行排序
public class Main implements Comparator {
    public static void main(String[] args) {
        List<int[]> allList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
//穷举出所有出站的顺序
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                arr[i] = num;
            }
            exhaustion(arr, allList, 0);
//判断筛选出这些顺序中合法的顺序
            allList.removeIf(l -> !ifLegal(l, arr));
//按照首元素的字典序进行排序
            allList.sort(new Main());
            for (int[] a : allList) {
                System.out.print(a[0]);
                for (int i = 1; i < a.length; i++) {
                    System.out.print(" " + a[i]);
                }
                System.out.println("");
            }
        }
    }

    private static void exhaustion(int[] arr, List<int[]> allList, int i) {
        if (i == arr.length - 1) {
            int[] tmp = arr.clone();
            allList.add(tmp);
            return;
        }
        for (int k = i; k < arr.length; k++) {
            swap(i, k, arr);
            exhaustion(arr, allList, i + 1);
            swap(i, k, arr);
        }
    }

    private static void swap(int i, int k, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    private static boolean ifLegal(int[] l, int[] a) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        stack.push(a[j++]);
        while (j != a.length) {
            if (!stack.isEmpty() && stack.peek() == l[i]) {
                stack.pop();
                i++;
            } else {
                stack.push(a[j++]);
            }
            if (stack.isEmpty() && j != a.length && i == l.length) {
                return true;
            }
        }
        for (int k = i; k < l.length; k++) {
            if (l[k] != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compare(Object o1, Object o2) {
        for (int i = 0; i < ((int[]) o1).length; i++) {
            int num = ((int[]) o1)[i] - ((int[]) o2)[i];
            if (num != 0) {
                return num;
            }
        }
        return 0;
    }
}
//
//class SampleComparator implements Comparator {
//    @Override
//    public int compare(Object o1, Object o2) {
//        return ((int[])o1)[0]-((int[])o2)[0];
//    }
//}