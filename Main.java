import java.util.*;

 class Main2{
    private static List<List<String>> arrayList = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int num = sc.nextInt();
            fun(str + " " + num);
            arrayList.sort(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    for (int i = 0; i < Math.min(o1.size(),o2.size()); i++){
                        if(o1.get(0).charAt(i) != o2.get(0).charAt(i)){
                           return o1.get(0).charAt(i)-o2.get(0).charAt(i);
                        }
                    }
                    return o1.get(0).length()-o2.get(0).length();
                }
            });
            for (List<String> list : arrayList) {
                for (String s : list) {
                    System.out.print(s + " ");
                }
            }
            System.out.println();
        }
    }
    public static void fun(String str){
        String sNum = "";
        String road = "";
        List<String> list = new ArrayList<>();
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) == ' '){
                sNum = str.substring(i+1);
                road = str.substring(0,i);
                break;
            }
        }
        for(int i = road.length()-1; i >= 0; i--){
            if(road.charAt(i) == '\\') {
                road = road.substring(i+1);
                break;
            }
        }
        if(road.length() > 16){
            road = road.substring(road.length()-16);
        }
        for(List<String> l : arrayList){
            if(road.equals(l.get(0)) && sNum.equals(l.get(1))){
                int num = Integer.parseInt(l.get(1));
                l.set(2, ++num + "");
                return;
            }
        }
        list.add(road);
        list.add(sNum);
        list.add("1");
        arrayList.add(list);
        return;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : array){
            int count = map.getOrDefault(a,0);
            map.put(a,++count);
        }
        Set<Integer> set = map.keySet();
        for(int a : set){
            if(map.getOrDefault(a,0) > array.length/2){
                return a;
            }
        }
        return 0;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<Integer> list = new ArrayList<>();
            int num = sc.nextInt();
            for(int i = 0; i < num; i++){
                list.add(sc.nextInt());
            }
            List<Integer> list1 = new ArrayList<>();
            for(int i : list){
                list1.add(Math.abs(i));
            }
            int k = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(Math.max(fun1(list, k, d),fun1(list1,k,d)));
        }
    }
    public static int fun1(List<Integer> list,int num,int d){
        List<Integer> arrayList = new ArrayList<>(list);
        listSort(arrayList);
        int count = arrayList.get(0);
        int index = list.indexOf(count);
        int size = 1;
        int a = 0;
        arrayList.remove((Integer) count);
        list.set(index,0);
        listSort(arrayList);
        int n = 0;
        while(size < num){
             n = arrayList.get(a);
             if(Math.abs(index - list.indexOf(n)) <= d){
                 arrayList.remove((Integer) n);
                 list.set(index,0);
                 a = 0;
                 count *= n;
                 size++;
                 index = list.indexOf(n);
             }else{
                 a++;
             }
        }
        return count;
    }
    public static void listSort(List<Integer> list){
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }
}