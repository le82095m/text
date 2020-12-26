package Work;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrLeft = new ArrayList<>();
        ArrayList<Integer> arrRight = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == null){
                arrLeft.add(null);
            }else{
                arrLeft.add(node.val);
            }
            if(node != null){
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == null){
                arrRight.add(null);
            }else{
                arrRight.add(node.val);
            }
            if(node != null){
                queue.add(node.right);
                queue.add(node.left);
            }
        }
        System.out.println(arrLeft);
        System.out.println(arrRight);
        return arrLeft.equals(arrRight);
    }
}
