package Soultion;

 class ListNode {
     int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

public class NC133 {
    public ListNode oddEvenList (ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newCur = new ListNode(-1);
        newHead.next = newCur;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            newCur.next = new ListNode(cur.val);
            cur = cur.next.next;
            newCur = newCur.next;
        }
        if(cur != null){
            newCur.next = new ListNode(cur.val);
            newCur = newCur.next;
        }
        cur = head.next;
        while(cur != null && cur.next != null){
            newCur.next = new ListNode(cur.val);
            cur = cur.next.next;
            newCur = newCur.next;
        }
        if(cur != null){
            newCur.next = new ListNode(cur.val);
            newCur = newCur.next;
        }
        return newHead.next.next;
    }
}
