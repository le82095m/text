package work;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> array_p = levelOrderTraversal(p);
        ArrayList<Integer> array_q = levelOrderTraversal(q);
        System.out.println(array_p);
        System.out.println(array_q);
        return array_p.equals(array_q);
    }
    public ArrayList<Integer> levelOrderTraversal(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        if(root == null){
            return array;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == null){
                array.add(0);
            }else{
                array.add(node.val);
            }
            if(node != null){
                queue.add(node.left);
            }
            if(node != null){
                queue.add(node.right);
            }
        }
        return array;
    }
}
