public class Tree {
    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree();
//        System.out.println(sumLife(root));
//        System.out.println(KNodeSize(root,1));
//        System.out.println(KNodeSize(root,2));
//        System.out.println(KNodeSize(root,3));
//        System.out.println(KNodeSize(root,4));
//        System.out.println(KNodeSize(root,5));
//        System.out.println(treeHigh(root));
        System.out.println(containsV(root, "Z"));
    }
    static int n = 0;
    public static int sumLife(TreeNode root){
        n = 0;
        sumLifeNode(root);
        return n;
    }
    public static void sumLifeNode(TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                n++;
            }
            sumLifeNode(root.right);
            sumLifeNode(root.left);
        }
    }
    public static int sumLifeNode2(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else{
            return sumLifeNode2(root.left)+sumLifeNode2(root.right);
        }
    }
    public static int KNodeSize(TreeNode root,int k){
        if(root == null){
            return 0;
        }else {
            if (k == 1) {
                return 1;
            }else {
                return KNodeSize(root.left, k - 1) + KNodeSize(root.right, k - 1);
            }
        }
    }
    public static int treeHigh(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(treeHigh(root.left),treeHigh(root.right))+1;
        }
    }
    public static boolean containsV(TreeNode root,String v){
        if(root == null){
            return false;
        }
        if(root.v.equals(v)) {
            return true;
        }
        if(containsV(root.left, v)){
            return true;
        }
        return containsV(root.right,v);
    }
}
