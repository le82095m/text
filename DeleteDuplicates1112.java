package work;


import java.util.Arrays;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val != pre.val){
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }
}
