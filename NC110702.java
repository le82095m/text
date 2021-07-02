package solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

      public TreeNode(int val) {
          this.val = val;
      }
  }
public class NC11 {
    public TreeNode sortedArrayToBST (int[] num) {
        int start = 0;
        int end = num.length-1;
        if(num.length == 0){
            return null;
        }
        return dfs(num,start,end);
    }
    public TreeNode dfs(int[] num,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2+(start+end)%2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = dfs(num,start,mid-1);
        node.right = dfs(num,mid+1,end);
        return node;
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        for (int i = 0; i < lists.size(); i++) {
            ListNode cur = lists.get(i);
            if (cur == null) {
                lists.remove(i);
            }
        }
        List<Integer> ary = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            for (ListNode tmp = lists.get(i);tmp != null;tmp = tmp.next) {
                ary.add(tmp.val);
            }
        }
        ary.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        for (int i = 0; i < ary.size(); i++) {
            ListNode a = new ListNode(ary.get(i));
            tmp.next = a;
            tmp = tmp.next;
        }
        return newHead.next;
    }
}
