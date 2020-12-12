import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comp {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(1);
        List<List<Integer>> allList = new ArrayList<>();
        allList.add(list1);
        allList.add(list2);
        allList.add(list3);
        for(List<Integer> list : allList){
            System.out.println(list);
        }
        allList.sort(new SampleComparator());
        for(List<Integer> list : allList){
            System.out.println(list);
        }
    }

    static class SampleComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return -1;
        }
    }
}
