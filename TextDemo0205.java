import java.util.Scanner;

    
     public class Test {
            private static int i = 1;

            public int getNext() {
                return i++;
            }

            public static void main(String[] args) {
                Test test = new Test();
                Test testObject = new Test();
                test.getNext();
                testObject.getNext();
                System.out.println(testObject.getNext());
            }



























    //{
    //{1,2, 8, 9},
    //{2,4, 9,12},
    //{4,7,10,13},
    //{6,8,11,15}
    //}

    //先判断该数字在[0][0]、[1][1]、[2][2]、[3][3]这几个数字的哪个范围里
    //然后由该数字想上下左右扩散

    public static boolean findNum(int[][] arr,int num){
        if(num == arr[0][0]){
            return true;
        }else if(num < arr[0][0]){
            return false;
        }else if(num < arr[1][1]){
            return num == arr[0][1] || num == arr[1][0];
        }
        int i;
        for (i = 0;i <3;i++) {
            if(num == arr[i+1][i+1]){
                return true;
            }
            if(num < arr[i+1][i+1]){
                break;
            }
        }
        if(i == 4){
            return false;
        } else{
            return num == arr[i + 1][i] || num == arr[i + 1][i - 1] || num == arr[i][i + 1] || num == arr[i - 1][i + 1];
        }
    }

    public static void main1(String[] args) {
        int [][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(findNum(arr,num)){
            System.out.println("存在");
        } else{
            System.out.println("不存在");
        }
    }
}
