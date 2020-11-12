package work;

class Solution {
    public int climbStairs1(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    public int climbStairs2(int n) {
        if(n < 1){
            return 1;
        }
        int[] jump = new int[n+2];
        jump[1] = 1;
        jump[2] = 2;
        for(int i = 3; i <= n ;i++){
            jump[i] = jump[i-1]+jump[i-2];
        }
        return jump[n];
    }

    public int climbStairs3(int n) {
        if(n < 3){
            return n;
        }
        int pre = 2;
        int prePre = 1;
        int sum = 0;
        while(n > 2){
            sum = prePre + pre;
            prePre = pre;
            pre = sum;
            n--;
        }
        return sum;
    }
}