 class Solution {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        ListNode newHead = null;
        if(l1.val > l2.val){
            newHead = l2;
            l2 = l2.next;
        }else{
            newHead = l1;
            l1 = l1.next;
        }
        ListNode cur = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val > cur2.val){
                cur.next = cur2;
                cur2 = cur2.next;
            }else{
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur  = cur.next;
        }
        if(cur1 != null){
            cur.next = cur1;
        }
        if(cur2 != null){
            cur.next = cur2;
        }
        return newHead;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
 class Solution1 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slowCur = head;
        ListNode fastCur = head;
        while(fastCur != null && fastCur.next != null){
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
            if(slowCur == fastCur){
                return true;
            }
        }
        return false;
    }
}
class Solution2 {
     public ListNode detectCycle(ListNode head) {
         if(head == null){
             return null;
         }
         ListNode slowCur = head;
         ListNode fastCur = head;
         while(fastCur != null && fastCur.next != null){
             slowCur = slowCur.next;
             fastCur = fastCur.next.next;
             if(slowCur == fastCur){
                 slowCur = head;
                 break;
             }
         }
         if(fastCur == null || fastCur.next == null){
             return null;
         }
         while(true){
             if(slowCur == fastCur){
                 return slowCur;
             }
             slowCur = slowCur.next;
             fastCur = fastCur.next;
         }
     }
    public int sqrt (int x) {
        long start = 0;
        long end = x;
        while(start < end){
            long mid = (start + end) / 2;
            if(mid * mid <= x && (mid+1)*(mid+1) > x){
                return (int)mid;
            }
            if(mid * mid < x){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return (int)start;
    }
 }