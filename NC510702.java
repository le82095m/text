package solution;

import java.util.ArrayList;

public class NC51 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        for (int i = 0; i < lists.size(); i++) {
            ListNode cur = lists.get(i);
            if (cur == null) {
                lists.remove(i);
            }
        }
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) == null){
                lists.remove(i);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(lists.size() > 0){
            int index = 0;
            for(int i = 0; i < lists.size(); i++){
                if(lists.get(i).val <= lists.get(index).val){
                    index = i;
                }
            }
            ListNode cur = lists.get(index);
            node.next = new ListNode(cur.val);
            node = node.next;
            lists.remove(cur);
            if(cur.next != null){
                lists.add(cur.next);
            }
        }
        return head.next;
    }
}
