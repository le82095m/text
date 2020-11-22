import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class work {
}

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}

//思路：
//1、定义一个队列，将根节点放入队列中
//2、做循环，当队列不为空时，将队列中首元素取出随机加入ArrayList，并加入其非空孩子
 class Solution {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.remove();
                size--;
                arr.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(arr);
        }
        return list;
    }
}
