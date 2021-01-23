class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Main{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;

        ListNode s1 = new ListNode(5);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(1);
        s1.next = s2;
        s2.next = s3;

        ListNode cur = new Plus().plusAB(l1,s1);
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
public class Plus {
    //链式A+B
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if(a == null && b == null){
            return null;
        }
        if(a == null)return b;
        if(b == null)return a;

        ListNode res = new ListNode(0);
        ListNode ap = a;
        ListNode bp = b;
        ListNode result = res;

        int flag = 0;
        int value;
        int val1;
        int val2;

        while(ap!=null || bp!=null || flag!=0){
            val1 = (ap == null ? 0 : ap.val);
            val2 = (bp == null ? 0 : bp.val);
            value = val1 + val2 + flag;

            flag = value/10;

            ListNode node = new ListNode(value%10);
            res.next = node;
            res = res.next;
            ap = (ap == null ? null:ap.next);
            bp = (bp == null ? null:bp.next);
        }
        return result.next;
    }
}