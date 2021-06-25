package Work;

import Work.ListNode;

//相加规则，同位结点val相加，将和作为新结点的val，如果有进位（>10），则val减10，下一位加一
//如果两位数相等，则直接相加，如果最后一位>10，则再加入一个新结点
//如果不相等，多的位的链表直接加到新链表后
class Solution {
    static boolean isLast = true;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        isLast = true;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode newHead = null;
        while(cur1 != null && cur2 != null){
            newHead = addTail(newHead,cur1.val+cur2.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(cur1 == null && cur2 == null){
            return newHead;
        }else if(cur1 != null){
            ListNode cur = cur1;
            while(cur1 != null){
                newHead = addTail(newHead,cur1.val);
                cur1 = cur1.next;
            }
        }else {
            while(cur2 != null){
                newHead = addTail(newHead,cur2.val);
                cur2 = cur2.next;
            }
        }
        return newHead;
    }
    public ListNode addTail(ListNode head,int val){
        ListNode cur = head;
        ListNode node = null;
        if(isLast){
            if(val < 10){
                node = new ListNode(val);
                isLast = true;
            }else{
                isLast = false;
                node = new ListNode(val-10,new ListNode(1));
            }
            if(head == null){
                head = node;
                return head;
            }
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            if(val < 9){
                cur.val = val+1;
                isLast = true;
            }else{
                isLast = false;
                cur.val = val - 9;
                cur.next = new ListNode(1);
            }
        }
        return head;
    }
}
