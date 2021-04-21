import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        ListNode cur = listNode;
        ListNode pre = null;
        ListNode curNext = cur.next;
        while(cur != null){
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        while(pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf(" ");
        while(index != -1){
            sb.deleteCharAt(index);
            sb.insert(index,"%20");
            index = sb.indexOf(" ");
        }
        return sb.toString();
    }
}
