import java.util.Scanner;

class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(getTotalCount(sc.nextInt()));
    }
    public static int getTotalCount(int monthCount){
        if(monthCount <= 0){
            return 0;
        }
        if(monthCount < 3){
            return 1;
        }else{
            return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
        }
    }
}
