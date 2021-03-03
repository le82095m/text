import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    /**
     *
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        class TreeAndHigh{
            TreeNode node;
            int high;

            public TreeAndHigh(TreeNode node, int high) {
                this.node = node;
                this.high = high;
            }
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot == null){
            return arrayLists;
        }
        Queue<TreeAndHigh> queue = new LinkedList<>();
        queue.add(new TreeAndHigh(pRoot,0));
        while(!queue.isEmpty()){
            TreeAndHigh tah = queue.remove();
            TreeNode node = tah.node;
            int index = tah.high;
            if (index >= arrayLists.size()) {
                arrayLists.add(new ArrayList<Integer>());
            }
            arrayLists.get(index).add(node.val);
            if(node.left != null){
                queue.add(new TreeAndHigh(node.left,index+1));
            }
            if(node.right != null){
                queue.add(new TreeAndHigh(node.right,index+1));
            }
        }
        return arrayLists;
    }



    /**
     *
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     *
     */
    String Serialize(TreeNode root) {
        String str = "";
        if(root == null){
            str += "#";
            return str;
        }
        if(root.left != null){
            str += Serialize(root.left);
        }
        if(root.right != null){
            str += Serialize(root.right);
        }
        return str;
    }
//    TreeNode Deserialize(String str) {
//
//    }
}
