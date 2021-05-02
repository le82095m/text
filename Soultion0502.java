import java.util.ArrayList;
import java.util.List;

public class Soultion {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        List<Integer> list = new ArrayList<>();
        for(int i : array){
            list.add(i);
        }
        List<Integer> newList = new ArrayList<>();
        for(int i : array){
            if(i%2 != 0){
                boolean b = list.remove((Integer)i);
                newList.add(i);
            }
        }
        newList.addAll(list);
        for(int i = 0; i < array.length; i++){
            array[i] = newList.get(i);
        }
        return array;
    }

     public class ListNode {
       int val;
       ListNode next = null;
       public ListNode(int val) {
         this.val = val;
       }
     }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *输入一个链表，输出该链表中倒数第k个结点。
         *如果该链表长度小于k，请返回空。
         *
         * @param pHead ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public ListNode FindKthToTail (ListNode pHead, int k) {
            if(pHead == null || k < 1){
                return null;
            }
            ListNode kCur = pHead;
            while(k > 1){
                if(kCur.next == null){
                    return null;
                }
                kCur = kCur.next;
                k--;
            }
            ListNode cur = pHead;
            while(kCur.next != null){
                kCur = kCur.next;
                cur = cur.next;
            }
            return cur;
        }
    }


    /**
     *
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     *
     * */

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        int num = list1.val > list2.val ? list1.val : list2.val;
        ListNode head = new ListNode(num);
        ListNode node = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                node.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                node.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            node = node.next;
        }
        if(list1 != null){
            node.next = list1;
        }
        if(list2 != null){
            node.next = list2;
        }
        return head.next;
    }
}
