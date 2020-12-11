//考虑到越界问题，将两数转为字符串，逐位相加
class UnusualAdd {
    public static void main(String[] args) {
    }
    public int addAB(int A, int B) {
        if(A < B){
            int temp = A;
            A = B;
            B = temp;
        }
        StringBuilder s1 = new StringBuilder(String.valueOf(A));
        StringBuilder s2 = new StringBuilder(String.valueOf(B));
        StringBuilder newStr = new StringBuilder("");
        int index = Math.abs(s1.length()-s2.length());
        int max = Math.max(s1.length(),s2.length());
        boolean ifCarry = false;
        for(int i = max-1;i >= index;i--){
            int sum = (s1.charAt(i)-'0')+(s2.charAt(i-index)-'0');
            if(ifCarry){
                sum++;
                ifCarry = false;
            }
            if(sum > 9){
                newStr.insert(0,sum-10);
                ifCarry = true;
            }else{
                newStr.insert(0,sum);
            }
        }
        if(index > 0) {
            int i = index - 1;
            if (ifCarry) {
                newStr.insert(0, s1.charAt(i) - '0' + 1);
                i--;
            }
            for (int j = i; j >= 0; j--) {
                newStr.insert(0, s1.charAt(j) - '0');
            }
        }
        return Integer.parseInt(newStr.toString());
    }
}