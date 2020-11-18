package tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class tree {
    public static List<Integer> afterOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root != null){
            List<Integer> leftList = afterOrder(root.left);
            list.addAll(leftList);
            List<Integer> rightList = afterOrder(root.right);
            list.addAll(rightList);
            list.add(root.val);
        }
        return list;
    }
    /*
    * 判断两棵树是否相同
    * 1、p和q都为空树
    * 2、p是空树q不是空树，或者p不是空树q是空树
    * 3、p.val == q.val
    *   p.left == q.left
    *   p.right == q.right
    * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    /*
    * 判断一棵树是否镜像对称
    * 1、root.left和root.right都为空时
    * 2、root.left为空root.right不为空，或者root.left不为空root.right为空时
    * 3、root.left.val = root.right.val && root.left.left == root.left.right && root.left.right == root.right.left
    */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isMirror(p.left,q.right) &&isMirror(p.right,q.left);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return search(s,t);
    }

    private boolean search(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        if(s.val == t.val){
            if(isSameTree(s,t)){
                return true;
            }
        }
        if(search(s.left,t)){
            return true;
        }
        return search(s.right,t);
    }
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth,rightDepth)+1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth-rightDepth) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
}