class Solution {
    class LinkedNode{
        int val;
        LinkedNode next;
        public LinkedNode(int num){
            this.val = num;
        }
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n<1){
            return -1;
        }
        LinkedNode head = new LinkedNode(0);
        LinkedNode cur = head;
        for(int i = 1;i < n;i++){
            cur.next = new LinkedNode(i);
            cur = cur.next;
        }
        cur.next = head;
        LinkedNode pre = cur;
        cur = head;
        while(cur.next != cur){
            for(int i = 0;i<m-1;i++){
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur = cur.next;
        }
        return cur.val;
    }
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0;i < B.length;i++){
            B[i] = 1;
            for(int j = 0;j < A.length;j++){
                if(i != j){
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
    public boolean isNumeric(char[] str) {
        boolean havePoint = false;
        boolean haveE = false;
        for(int i = 0 ; i<str.length ; i++){
            if(str[i] != '.' && str[i] != 'E' && str[i] !='e' && str[i] != '+' && str[i] != '-' &&( str[i] > '9' || str[i] < '0')){
                return false;
            }
            if(str[i] == '.'){
                if(havePoint || haveE){
                    return false;
                }
                havePoint = true;
            }
            if(str[i] == 'e' || str[i] == 'E'){
                if(i == str.length-1){
                    return false;
                }
                haveE = true;
            }
            if(str[i] == '+' || str[i] == '-'){
                if(i != 0 && str[i-1] !='E' && str[i-1] !='e'){
                    return false;
                }
            }
        }
        return true;
    }
}
