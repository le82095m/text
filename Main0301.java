import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(Arrays.toString(s.printMatrix(new int[][]{{1,2},{3,
//                4}}).toArray()));
//        System.out.println(s.VerifySquenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{4,6,7,5}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{1,2,3,4,5}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{5}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{7,4,6,5}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{4,6,12,8,16,14,10}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{}));
//        System.out.println(s.VerifySquenceOfBST(new int[]{7,4,9,3,8,11,12,10}));
        TreeNode root = BuildTree.buildTree();
        System.out.println(Arrays.toString(s.preOrder(root).toArray()));
    }
}
