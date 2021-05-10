import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class NowcoderDemo {
    public class Solution {
        /**
         *
         * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
         *
         * */
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> list = new ArrayList();
            if(root == null){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            return list;
        }
    }

    /**
     *
     *输入一个复杂链表
     *（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针random指向一个随机节点）
     *请对此链表进行深拷贝，并返回拷贝后的头结点。
     *
     */

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode node = new RandomListNode(-1);
        RandomListNode nodeCur = node;
        RandomListNode cur = pHead;
        while(cur != null){
            nodeCur.next = new RandomListNode(cur.label);
            nodeCur = nodeCur.next;
            map.put(cur,nodeCur);
            nodeCur.random = cur.random;
            cur = cur.next;
        }
        nodeCur = node.next;
        while (nodeCur != null){
            nodeCur.random = map.get(nodeCur.random);
            nodeCur = nodeCur.next;
        }
        return node.next;
    }
}
