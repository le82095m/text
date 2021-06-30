package Soultion;

public class NC21 {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        int length = 0;
        if(n <= m){
            return head;
        }
        int index = 1;
        ListNode cur = head;
        ListNode pre = null;
        while(index < m){
            pre = cur;
            cur = cur.next;
            if(cur == null){
                return head;
            }
            index++;
        }
        ListNode prev = pre;
        ListNode last = cur;
        pre = cur;
        cur = cur.next;
        if(cur == null){
            return head;
        }
        ListNode curNext = cur.next;
        while(index < n && cur != null){
            cur.next = pre;
            pre = cur;
            cur = curNext;
            if(curNext != null){
                curNext = curNext.next;
            }
            index++;
        }
        if(m == 1){
            head = pre;
        }else{
            prev.next = pre;
        }
        last.next = cur;
        return head;
    }
}
