import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        System.out.println(numOfBag(n));
    }
    public static int numOfBag(int n){
        int size = 0;
//        if(n % 6 == 0){
//            size = n / 6;
//        }else{
//            size = (n / 6) + 1;
//        }
        List<Integer> list = new ArrayList<>();
        for(int j = 0 ; j <= n;j++){
            for(int i = 0;i <= n;i++){
                if(6*i + 8*j == n){
                    list.add(i+j);
                }
            }
        }
        if(list.size()==0){
            return -1;
        }
        int num = n;
        for(int i = 0;i < list.size();i++){
            num = list.get(i) < num ? list.get(i):num;
        }
        return num;
    }
}
