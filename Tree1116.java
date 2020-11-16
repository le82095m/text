package tree;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
class threeOrders{
    static TreeNode[] arr;
    static int i = 0;
    public static void afterOrders(TreeNode root){
        arr[i] = root;
        i++;
        if(root.left != null){
            afterOrders(root.left);
        }
        if(root.right != null){
            afterOrders(root.right);
        }
    }
    public static void midOrders(TreeNode root){
        if(root.left != null){
            afterOrders(root.left);
        }
        arr[i] = root;
        i++;
        if(root.right != null){
            afterOrders(root.right);
        }
    }
    public static void lastOrders(TreeNode root){
        if(root.left != null){
            afterOrders(root.left);
        }
        if(root.right != null){
            afterOrders(root.right);
        }
        arr[i] = root;
        i++;
    }
}
