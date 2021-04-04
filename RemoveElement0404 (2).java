package leetCode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        int num = 0;
        while(cur != null){
            cur = cur.next;
            num++;
        }
        if(n> num){
            return head.next;
        }
        ListNode pre = null;
        cur = head;
        for(int i=0 ; i < num-n;i++){
            pre = cur;
            cur = cur.next;
        }
        if(pre == null){
            return head.next;
        }
        pre.next = cur.next;
        return head;
    }
}
