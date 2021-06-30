package Soultion;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

class Solution1
{
    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            if(list.get(left).val != list.get(right).val){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}