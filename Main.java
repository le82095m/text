import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int x0 = sc.nextInt();
//        int y0 = sc.nextInt();
//        int z0 = sc.nextInt();
//        int x1 = sc.nextInt();
//        int y1 = sc.nextInt();
//        int z1 = sc.nextInt();
        int x0 = 1;
        int y0 = 1;
        int z0 = 1;
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;
        double r = Math.sqrt(Math.pow(x1-x0,2)+Math.pow(y1-y0,2)+Math.pow(z1-z0,2));
        double v = Math.pow(r,3)*Math.acos(-1)*4/3;
        System.out.printf("%.3f %.3f",r,v);
    }
}
