import java.util.*;


class TreeNode{
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}

public class Order{
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

class Solution {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        List<Integer> list1 = firstOrder(root,new ArrayList<>());
        Integer[] f = new Integer[list1.size()];
        f = list1.toArray(f);
        List<Integer> list2 = midOrder(root,new ArrayList<>());
        Integer[] o = new Integer[list2.size()];
        o = list2.toArray(o);
        List<Integer> list3 = lastOrder(root,new ArrayList<>());
        Integer[] l = new Integer[list3.size()];
        l = list3.toArray(l);
        Integer[][] r = new Integer[3][f.length];
        r[0] = f;
        r[1] = o;
        r[2] = l;
        int[][] a = new int[r.length][r[0].length];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < r[0].length; j++) {
                a[i][j] = r[i][j];
            }
        }
        return a;
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
