import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.*;

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}

class Solution {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static void main(String[] args) {

    }
        public int[][] threeOrders (TreeNode root) {

        }
        public List<Integer> firstOrder(TreeNode root,List<Integer> list){
            if(root != null) {
                list.add(root.val);
                firstOrder(root.left, list);
                firstOrder(root.right, list);
            }
            return list;
        }
        public List<Integer> midOrder(TreeNode root, List<Integer> list) {
            if (root != null) {
                midOrder(root.left, list);
                list.add(root.val);
                midOrder(root.right, list);
            }
            return list;
        }
        public List<Integer> lastOrder(TreeNode root,List<Integer> list){
            if (root != null) {
                midOrder(root.left, list);
                midOrder(root.right, list);
                list.add(root.val);
            }
            return list;
        }
    }
}
