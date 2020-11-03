public class TestDemo {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//相加规则，同位结点val相加，将和作为新结点的val，如果有进位（>10），则val减10，下一位加一
//如果两位数相等，则直接相加，如果最后一位>10，则再加入一个新结点
//如果不相等，多的位的链表直接加到新链表后
class Solution {
    static boolean isLast = true;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }
    public ListNode addTial(ListNode head,int val){
        if(isLast == true){
            if(val < 10){
                ListNode node = new ListNode(val);
            }else{
                isLast = false;
                ListNode node = new ListNode(val-10,new ListNode(1));
            }
        }
        ListNode cur = head;
        if(head == null){
            head = node;
            return head;
        }
        while(cur.next != null){
            cur = cur.next;
        }
    }
}

