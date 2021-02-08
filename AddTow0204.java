import java.util.HashMap;

public class AddTow {
    public static void main(String[] args) {
//        System.out.println(countNumberOf2s1(10));
//        System.out.println(countNumberOf2s3(10));
//        System.out.println(countNumberOf2s1(30));
//        System.out.println(countNumberOf2s3(30));
//        System.out.println(countNumberOf2s1(100));
//        System.out.println(countNumberOf2s3(100));
//        System.out.println(countNumberOf2s1(22));
//        System.out.println(countNumberOf2s3(22));
        System.out.println(countNumberOf2s3(1000000000));
//        System.out.println(countNumberOf2s1(202) - countNumberOf2s3(202));
    }

    public static int countNumberOf2s2(int n) {
        int carry = 0;
        int count = 0;
        while (n > 0) {
            int a = (n % 10) * (int) Math.pow(10, carry);
            count += fun1(a);
            carry++;
            n /= 10;
        }
        return count;
    }

    public static int fun1(int n) {
        int carry = 0;
        int count = 0;
        if (n == 2) {
            return 1;
        }
        while (n > 0) {
            int a = n % 10;
            count += a * Math.pow(10, carry - 1) * (carry);
            if (a > 2) {
                count += Math.pow(10, carry);
            }
            carry++;
            n /= 10;
        }
        return count;
    }

    public static int countNumberOf2s(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += fun(i);
        }
        return count;
    }

    public static int fun(int num) {
        int count = 0;
        while (num > 0) {
            int n = num % 10;
            if (n == 2) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static int countNumberOf2s1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }

    public static int countNumberOf2s3(int n) {
        int count = 0;
        for(int i = 0; i <= n;i++){
            count += fun3(i+"");
        }
        return count;
    }

    public static int fun3(String num) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < num.length();i++){
            int count = map.getOrDefault(num.charAt(i),0);
            map.put(num.charAt(i),++count);
        }
        return map.getOrDefault('2',0);
    }
}