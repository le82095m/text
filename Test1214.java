public class Test {
    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r4.left = r8;
        r4.right = r9;
        System.out.println(s.levelOrderTraversal(r1));
        System.out.println(s.levelOrderTraversal(r3));
        System.out.println(s.inorderTraversal(r1).toString());
        System.out.println(s.inorderTraversal(r3).toString());
        System.out.println(s.inorderTraversal(r1).containsAll(s.inorderTraversal(r3)));

    }
}