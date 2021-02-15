import java.util.ArrayList;
import java.util.List;

public class Tree {
    public static TreeNode containsNode(TreeNode root,TreeNode node){
        if(root == null){
            return null;
        }
        if(root.equals(node)){
            return root;
        }
        TreeNode containsLeft = containsNode(root.left,node);
        if(containsLeft != null){
            return containsLeft;
        }
        return containsNode(root.right,node);
    }
    public static List<String> preorderTraversal(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root != null) {
            list.add(root.v);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }
    public static List<String> midTraversal(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root != null){
            list.addAll(midTraversal(root.left));
            list.add(root.v);
            list.addAll(midTraversal(root.right));
        }
        return list;
    }
    public static List<String> lastTraversal(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root != null){
            list.addAll(lastTraversal(root.left));
            list.addAll(lastTraversal(root.right));
            list.add(root.v);
        }
        return list;
    }
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null){
            return false;
        }
        if(q == null){
            return false;
        }
            return (p.v.equals(q.v)) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public static boolean isMirror(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.v.equals(q.v) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
    public static boolean isSubTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        if(t == null){
            return true;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubTree(s.left,t)){
            return true;
        }
        return isSubTree(s.right,t);
    }
    public static int highTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(highTree(root.left),highTree(root.right))+1;
    }
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        if(Math.abs(highTree(root.left)-highTree(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
