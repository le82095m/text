import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
//        list.add("1111111111111111111");
//        list.add("2222222222222222222222");
//        list.add("3333333333333333");
        list.sort(new SampleComparator());
        for (String s : list) {
            System.out.println(s);
        }
    }

    static class SampleComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (((String) o1).length() != ((String) o2).length()) {
                return ((String) o2).length() - ((String) o1).length();
            } else {
                return ((String) o2).charAt(0) - ((String) o1).charAt(0);
            }
        }
    }
}
