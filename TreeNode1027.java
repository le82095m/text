package Tree;

public class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}
