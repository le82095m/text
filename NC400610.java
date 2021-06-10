class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
public class NC40 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        ListNode node1 = res(head1);
        ListNode node2 = res(head2);
        int a = 0;
        ListNode head = new ListNode(-1);
        ListNode newHead = head;
        while(node1 != null && node2 != null){
            int num = node1.val+node2.val+a;
            if(num > 9){
                num = num % 10;
                a = 1;
            }else{
                a = 0;
            }
            newHead.next = new ListNode(num);
            newHead = newHead.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode temp = null;
        if(node1 != null){
            temp = node1;
        }else if(node2 != null){
            temp = node2;
        }
        while(temp != null){
            int num = temp.val + a;
            if(num > 9){
                num = num % 10;
                a = 1;
            }else{
                a = 0;
            }
            newHead.next = new ListNode(num);
            newHead = newHead.next;
            temp = temp.next;
        }
        return res(head.next);
    }
    public ListNode res(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode newCur = head;

        while(cur != null){
            cur = cur.next;
            newCur.next = prev;
            prev = newCur;
            newCur = cur;
        }
        return prev;
    }
}
