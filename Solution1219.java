//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}
//
public class Solution {
//    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
//
//    }
//    public boolean isSonTree(TreeNode root1,TreeNode root2) {
//        while (root1 != null && root2 != null){
//            if(root1 != root2){
//                return false;
//            }
//            root1 = root1.left;
//            root2 = root2.left;
//        }
//    }
    public int GetUglyNumber_Solution(int index) {
        int i = 1;
        while(index > 0) {
            if (isUglyNumber(i)) {
                index--;
            }
            i++;
        }
        return i-1;
    }
    public static boolean isUglyNumber(int num){
        for (int i = 2; i <= num;i++){
            if(num % i == 0){
                if(i % 2 != 0 && i % 3 != 0 && i % 5 !=0){
                    return false;
                }
            }
        }
        return true;
    }
}