import java.util.*;
public class Main{
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        String str = "";
        list.sort(new SampleComparator());
        if(list.get(0) == 0){
            for(int i = 0;i < list.size();i++){
                if(list.get(i) != 0){
                     str = str + list.remove(i);
                }
            }
        }
        for(int i = 0;i < list.size();i++){
             str = str+list.get(i);
        }
        System.out.println(str);
    }
}
class SampleComparator implements Comparator{
    public int compare(Object o1, Object o2){
        return (int)o1 - (int)o2;
    }
}
