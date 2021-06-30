package Soultion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TAL{
    TreeNode node;
    int high;

    public TAL(TreeNode node, int high) {
        this.node = node;
        this.high = high;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class NC14 {
    public static void main(String[] args) {
        TreeNode node = BuildTree.buildTree();
        zigzagLevelOrder1(node);
    }

    public static void afterOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        afterOrder(root.left);
        afterOrder(root.right);
    }

    public static void leaveOrder(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.remove();
            System.out.print(node.val+" ");
            if(node.left != null){
                deque.add(node.left);
            }
            if(node.right != null){
                deque.add(node.right);
            }
        }
    }
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        return null;
    }

    public static void zigzagLevelOrder1 (TreeNode root) {
        if(root == null){
            return;
        }
        Deque<TAL> stack = new LinkedList<>();
        stack.push(new TAL(root,0));
        while(!stack.isEmpty()){
            TAL t = stack.pop();
            System.out.print(t.node.val+" ");
            if(t.high % 2 != 0) {
                if (t.node.left != null) {
                    stack.push(new TAL(t.node.left, t.high + 1));
                }
                if (t.node.right != null) {
                    stack.push(new TAL(t.node.right, t.high + 1));
                }
            }else{
                if (t.node.right != null) {
                    stack.push(new TAL(t.node.right, t.high + 1));
                }
                if (t.node.left != null) {
                    stack.push(new TAL(t.node.left, t.high + 1));
                }
            }
        }
    }

}
