package Soultion;

import java.util.Random;

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}

class Solution2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode cur = node;
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            cur.next = new ListNode(random.nextInt(100));
            cur = cur.next;
        }
        cur = node;
        while (cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        cur = sortInList(node);
        System.out.println();
        while (cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList (ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        for(int i = length; i > 0; i--){
            cur = head;
            ListNode pre = null;
            ListNode curnext = cur.next;
            for(int j = 0; j < i-1 ; j++){
                if(cur.val > curnext.val){
                    if(pre != null){
                        pre.next = curnext;
                    }else{
                        head = curnext;
                    }
                    cur.next = curnext.next;
                    curnext.next = cur;
                    ListNode t = curnext;
                    curnext = cur;
                    cur = t;
                }
                pre = cur;
                cur = cur.next;
                curnext = curnext.next;
            }
        }
        return head;
    }
}