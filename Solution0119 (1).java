public class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class Partition {
        public ListNode partition(ListNode pHead, int x) {
            if(pHead == null){
                return null;
            }
            ListNode minHead = null;
            ListNode maxHead = null;
            ListNode minCur = minHead;
            ListNode maxCur = maxHead;
            while(pHead != null){
                if(pHead.val < x){
                    if(minHead == null){
                        minHead = pHead;
                        minCur = minHead;
                    }else{
                        minCur.next = pHead;
                        minCur = minCur.next;
                    }
                }else{
                    if(maxHead == null){
                        maxHead = pHead;
                        maxCur = maxHead;
                    }else{
                        maxCur.next = pHead;
                        maxCur = maxCur.next;
                    }
                }
                pHead = pHead.next;
            }
            maxCur.next = null;
            if(minCur != null){
                minCur.next = maxHead;
            }
            return minHead;
        }
    }
}
