import java.util.*;
public class Main{
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < num;i++){
            list.add(i);
        }
        int index = 0;
        while(list.size()>1){
            if(index == list.size()-2){
                index = 0;
            }else if(index == list.size()-1){
                index = 1;
            }else{
                index +=2;
            }
            list.remove(index);
            if(index == list.size()) {
                index = 0;
            }
        }
        System.out.print(list.remove());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        int num = list.remove(list.size()-1);
        Object[] arr = list.toArray();
        Arrays.sort(arr);
        for(int i = 0;i < num;i++){
            System.out.print(arr[i]+" ");
        }
    }
}