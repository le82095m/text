import java.util.*;
//1、穷举出所有出站的顺序
//2、判断筛选出这些顺序中合法的顺序
//3、按照首元素的字典序进行排序
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> allList = new ArrayList<>();
        exhaustion(list,allList,0);
        for(List<Integer> l : allList) {
            if(!ifLegal(l)){
                allList.remove(l);
            }
        }
        allList.sort(new SampleComparator());
    }

    private static void exhaustion(List<Integer> list, List<List<Integer>> allList, int i) {

    }

    private static boolean ifLegal(List<Integer> list) {
        return true;
    }
}
class SampleComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        return (int)o1-(int)o2;
    }
}