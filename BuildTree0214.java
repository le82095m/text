public class BuildTree {
    public static TreeNode buildTree() {
        TreeNode node1 = new TreeNode("A");
        TreeNode node2 = new TreeNode("B");
        TreeNode node3 = new TreeNode("C");
        TreeNode node4 = new TreeNode("D");
        TreeNode node5 = new TreeNode("E");
        TreeNode node6 = new TreeNode("F");
        TreeNode node7 = new TreeNode("G");
        TreeNode node8 = new TreeNode("H");
        TreeNode node9 = new TreeNode("I");
        TreeNode node10 = new TreeNode("J");
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node6.left = node7;
        node5.right = node8;
        node8.left = node9;
        node8.right = node10;
        return node1;
    }
}
