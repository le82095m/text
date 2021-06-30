package Soultion;

public class BuildTree {
    public static TreeNode buildTree(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node5.right = node8;
        node6.left = node7;
        node8.left = node9;
        node8.right = node10;
        return node1;
    }
}
