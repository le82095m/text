import java.util.Arrays;
public class TestDemo {

    public static int[] assign(int[] arr){
        for (int i = 1; i <=arr.length ; i++) {
            arr[i-1] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        System.out.println(Arrays.toString(assign(arr)));
    }






    public static int arrSum(int[] arr){
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            sum +=arr[i];
        }
        return sum;
    }

    public static void main(String[]args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(arrSum(arr));
        }

//
//    public static double avg(int[] arr){
//        double sum = 0.0;
//        for(int i = 0;i < arr.length;i++){
//            sum += arr[i];
//        }
//        return sum/(arr.length);
//    }
//
//    public static void main(String[] args) {
//        int []arr = new int[]{2,2,3,4,5,6,7,8,9};
//        System.out.println(avg(arr));
//    }

//        public static void move( int n, String from, String buffer, String to){
//            if (n == 1) {
//                System.out.print("from" + from + "to" + to+" ");
//            } else {
//                move(n - 1, from, to, buffer);
//                move(1, from, buffer, to);
//                move(n - 1, buffer, from, to);
//            }
//        }
//
//
//    public static void main(String[] args) {
//            int n = 3;
//            move(3,"石柱1","石柱2","石柱3");
//    }

     /*
//    * 青蛙跳台阶问题，无论还有多少阶台阶，只要该台阶数大于1，则只有两种跳法
//    * 假设从第n层台阶开始跳到顶端有f(n)种跳法，则f(n)=f(n-1)+f(n-2)
//    * */
//    public static int frog(int n){
//        if(n == 1){
//            return 1;
//            //当仅有一个台阶时，青蛙只有一种跳法
//        } else if(n == 2){
//            return 2;
//            //当有两个台阶时，青蛙有(1+1)，2两种跳法
//        } else {
//            return frog(n-1)+frog(n-2);
//            //当台阶大于2时，从该台阶起跳只有两种可能，剩余台阶为n-1，或为n-2
//        }
//    }
//
//    public static int frog2(int n){
//        int a = 1;
//        int b = 2;
//        int temp = 0;
//        for(int i = 3;i <= n;i++){
//            temp = a + b;
//            a = b;
//            b = temp;
//        }
//        return temp;
//    }

//    public static void formNum(int n){
//        if(n < 10){
//            System.out.print(n%10+" ");
//        } else {
//             formNum(n/10);
//            System.out.print(n%10+" ");
//        }
//    }

//    public static int numAdd(int n){
//        if(n == 1){
//            return 1;
//        } else {
//            return n*numAdd(n-1);
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 5;
//        System.out.println(numAdd(n));
//    }

//    public static int fib(int n){
//        if(n<2){
//            return n;
//        } else {
//            return fib(n-1)+fib(n-2);
//        }
//    }
//
//    public static void main(String[] args) {
//        int n=5;
//        System.out.println(fib(n));
//    }

//    public static int sumNum(int a,int b){
//        return a+b;
//    }
//    public static double sumNum(double a,double b,double c){
//        return a+b+c;
//    }
//    public static void main(String[] args) {
//        double x = 10.0;
//        double y = 20.0;
//        double z = 15.0;
//        int a = 10;
//        int b = 15;
//        System.out.println(sumNum(x,y,z));
//    }
}
