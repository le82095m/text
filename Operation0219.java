import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Operation {
    public static Node headAdd(Node head,int e){
        Node node = new Node(e);
        if (head != null) {
            node.next = head;
        }
        head = node;
        return head;
    }
    public static Node tailAdd(Node head,int e){
        Node node = new Node(e);
        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        return head;
    }
    public static Node headRemove(Node head){
        if(head == null){
            return null;
        }else{
            head = head.next;
            return head;
        }
    }
    public static Node tailRemove(Node head){
        if(head == null || head.next == null){
            return null;
        } else{
            Node pre = head;
            Node cur = head;
            while (cur.next != null){
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
        }
        return head;
    }

    public static int TreeHigh(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(TreeHigh(root.left),TreeHigh(root.right))+1;
    }

    public static void leaveOrder(TreeNode root){
        if(root == null){
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
}
