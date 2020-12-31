import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.Arrays;

class Test {
    public static void rand(int[] arr,int size){
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size-j-1; i++) {
                if (arr[i] % 2 == 0) {
                    arr[i] ^= arr[i + 1];
                    arr[i + 1] ^= arr[i];
                    arr[i] ^= arr[i + 1];
                }
            }
        }
    }
    class Print extends Object{

    }
    public static void main1(String [] args){
            int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
            rand(arr,9);
        System.out.println(Arrays.toString(arr));
        }
}
class Test1 {
    public static int count(int num){
        int count = 0;
        for (int i = 0; i <32 ; i++) {
            if((num & 1)==1){
                count++;
            }
            num >>>= 1;
        }
        return count;
    }

    public static void main2(String[] args) {
        int num = 4;
        System.out.println(count(num));
    }
}

class Test2{
    public static String find(int[] arr,int num,int size) {
        for (int j = 0; j < size-1; j++) {
            for (int i = j+1; i <size-1; i++) {
                if (arr[j] + arr[i] == num) {
                    return j+" "+(i+1);
                }
            }
        }
        return "null";
    }
    public static void main3(String[] args) {
        int num = 8;
        int[] arr =new int[]{1,2,3,4,5,6,7,8};
        System.out.println(find(arr,num,8));
    }
}

class Test3{
    public static void main4(String[] args) {
        int z = 0;
        int x = z = 2,y = 3;
        if (x > y)
            z = 1;
        else if (x == y)
            z = 0;
        else
            z = -1;
        System.out.println(z);
    }
}
class Test4{
    public static int found(int[] arr){
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == arr[i+1]){
                count++;
            }else{
                count = 0;
            }
            if(count == arr.length/2){
                return arr[i];
            }
        }
        return 0;
    }
    public static void main9(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        Arrays.sort(arr);
        System.out.println(found(arr));
    }
}
    class Example{
    String str = new String("good");
    char[]ch = {'a','b','c'};
    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
        
    }
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'g';
    }
}

class Test8{
    public static int fun(int[] arr){
        int sum = arr[0];
        int temp = 0;
        for (int i = 0; i <arr.length-1; i++) {
            if(arr[i]+arr[i+1] < 0){
                if(sum < temp){
                    sum = temp;
                    temp = 0;
                }
            }else{
                temp += arr[i+1];
            }
        }
        return sum;
    }
    public static void main9(String[] args) {
        int[] arr = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(fun(arr));
    }
}

class Test9{
    public static int xor(int[] arr){
        int num = 0;
        for (int value : arr) {
            num ^= value;
        }
        return num;
    }
    public static void classify(int[] arr,int num,int[] arrA,int[] arrB){
        int countA = 0,countB = 0;
        for (int i = 0; i < arr.length ; i++) {
            if((arr[i] & num) == 0){
                arrA[i] = arr[countA];
                countA++;
            }else{
                arrB[i] = arrB[countB];
                countB++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,1,3,5,9};
        int[] arrA = new int[arr.length];
        int[] arrB = new int[arr.length];
        classify(arr,xor(arr),arrA,arrB);
        System.out.println(xor(arrA));
        System.out.println(xor(arrB));
    }
}

//将"abcdef"当k等于2时，进行旋转，得到结果为："cdefab"
class Test10{
    public static void funtaion(String str){
        
    }
    public static void main(String[] args) {

    }
}

//"aabbccdaa" -> "a2b2c2d1a2" 或者 例如："abbcccffr" -> "a1b2c3f2r1"
class Test11{
    public static void main(String[] args) {

    }
}

class Test12{
    public static int findNum(int[] arr){
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num ^= arr[i];
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,6,3,1,9,2,6,1};
        System.out.println(findNum(arr));
    }
}
 class Demo {
     public int add(int a, int b) {
         try {
             return a + b;
         } catch (Exception e) {
             System.out.println("Catch 语句块");
         } finally {
             System.out.println("finally 语句块");
         }
     } return 0;

     public static void main(String[] args) {
         Demo demo = new Demo();
         System.out.println("和是：" + demo.add(9, 34));
     }
 }