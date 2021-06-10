public class NC53 {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode cur1 = head;
        for(int i = 0; i < n ;i++){
            if(cur1 == null){
                return head;
            }
            cur1 = cur1.next;
        }
        ListNode prev = null;
        ListNode cur2 = head;
        while(cur1 != null){
            prev = cur2;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        if(prev == null){
            return cur2.next;
        }
        prev.next = cur2.next;
        return head;
    }
}
