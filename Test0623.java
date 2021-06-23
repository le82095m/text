import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Test {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while (n > 0){
            if(cur == null){
                return head;
            }
            cur = cur.next;
            n--;
        }
        ListNode prev = null;
        ListNode node = head;

        while(cur != null){
            prev = node;
            node = node.next;
            cur = cur.next;
        }
        if(prev == null){
            return head.next;
        }
        prev.next = node.next;
        return head;
    }
    public int foundOnceNumber (int[] arr, int k) {
        int res = 0;
        if(k % 2 == 0){
            for(int num : arr){
                res ^= num;
            }
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            int count = map.getOrDefault(num,0);
            map.put(num,++count);
        }
        for(int num : map.keySet()){
            if(map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
