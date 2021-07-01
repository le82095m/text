package solution;

class ListNode{
    ListNode next;
    int val;
    public ListNode(int num){
        val = num;
    }
}
public class NC132 {
    /**
     *
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public int ysf (int n, int m) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i = 1; i <= n; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        m--;
        cur.next = head.next;
        cur = head.next;
        int count = 1;
        while(n > 1){
            if(count < m){
                count++;
            }else{
                cur.next = cur.next.next;
                n--;
                count = 1;
            }
            cur = cur.next;
        }
        return cur.val;
    }
}
