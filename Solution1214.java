import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return " " + val;
    }
}

public class Solution {
    public static void main(String[] args) {
//        int[] n = new int[]{2,8,5,4,1,3,6,9};
//        new Solution().reOrderArray(n);
//        System.out.println(Arrays.toString(n));
    }
    public void reOrderArray(int [] array) {
//         1、创建一个新的数组
//         int[] newArr = array.clone();
//         int index = 0;
//         for(int num : newArr){
//             if(num % 2 != 0){
//                 array[index++] = num;
//             }
//         }
//         for(int num : newArr){
//             if(num % 2 == 0){
//                 array[index++] = num;
//             }
//         }
        //2、利用选择排序思想
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] % 2 != 0){
                shift(count,i,array);
                count++;
            }
        }
    }

    private void shift(int count,int i, int[] array) {
        int num = array[i];
        for(int j = i; j > count;j--){
            array[j] = array[j-1];
        }
        array[count] = num;
    }


    public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        if(fun(root1,root2) == 1){
            return true;
        }
        return false;
    }
    public int fun(TreeNode root1,TreeNode root2){
        if(root1 != null && root2 != null){
            return fun(root1.left,root2.left)*fun(root1.right,root2.right);
        }
        if(root1 != root2){
            return 0;
        }else{
            return 1;
        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        String s1 = levelOrderTraversal(root1);
        String s2 = levelOrderTraversal(root2);
        return s1.contains(s2);
    }
    public String levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        String str = "";
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            str += node.val;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return str;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            List<Integer> leftList = inorderTraversal(root.left);
            list.addAll(leftList);
            list.add(root.val);
            List<Integer> rightList = inorderTraversal(root.right);
            list.addAll(rightList);
        }
        return list;
    }
}