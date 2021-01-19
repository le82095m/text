public class Test {
    public static void main(String[] args) {
        Solution.ListNode listNode1 = new Solution.ListNode(2);
        Solution.ListNode listNode2 = new Solution.ListNode(8);
        Solution.ListNode listNode3 = new Solution.ListNode(7);
        Solution.ListNode listNode4 = new Solution.ListNode(1);
        Solution.ListNode listNode5 = new Solution.ListNode(4);
        Solution.ListNode listNode6 = new Solution.ListNode(9);
        Solution.ListNode listNode7 = new Solution.ListNode(6);
        Solution.ListNode listNode8 = new Solution.ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        Solution.Partition p = new Solution.Partition();
        Solution.ListNode cur = p.partition(listNode1,5);
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
