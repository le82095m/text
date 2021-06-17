 class ListNode {
    int val;
    ListNode next = null;
  }

public class Test {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while (n > 0){
            if(cur == null){
                return head;
            }
            cur = cur.next;
            n--;
        }
        ListNode prev = null;
        ListNode node = head;

        while(cur != null){
            prev = node;
            node = node.next;
            cur = cur.next;
        }
        if(prev == null){
            return head.next;
        }
        prev.next = node.next;
        return head;
    }
}
