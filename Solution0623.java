import java.util.*;

//class ListNode {
//    int val;
//   ListNode next = null;
// }

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2; i < 10; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head = deleteDuplicates(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup (ListNode head, int k){
        ListNode node = head;
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        if(head == null || k > size){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode curNext = cur.next;
        ArrayList<ListNode> list = new ArrayList<>();
        int index = 0;
        while(cur != null){
            int num = k;
            if(index+k > size){
                list.add(cur);
                break;
            }
            while(num > 0 && cur != null){
                cur.next = prev;
                prev = cur;
                cur = curNext;
                num--;
                if(cur != null){
                    curNext = cur.next;
                }
                index++;
            }
            if(prev != null){
                list.add(prev);
                prev = null;
            }
        }
        for(int i = 0; i < list.size()-1; i++){
            ListNode n = list.get(i);
            while(n.next != null){
                n = n.next;
            }
            n.next = list.get(i+1);
        }
        return list.get(0);
    }


    public static ListNode deleteDuplicates (ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        Map<Integer,ArrayList<ListNode>> map = new TreeMap<>();
        while(cur != null){
            ArrayList<ListNode> list = map.getOrDefault(cur.val,new ArrayList<>());
            list.add(cur);
            map.put(cur.val,list);
            cur = cur.next;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        for(int num : map.keySet()){
            ArrayList<ListNode> l = map.get(num);
            if(l.size() == 1){
                list.add(l.get(0));
            }
        }
        if(list.size() == 0){
            return null;
        }
        for(int i = 0; i < list.size()-1; i++){
            list.get(i).next = list.get(i+1);
        }
        list.get(list.size()-1).next = null;
        return list.get(0);
    }
}