class Node{
    String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val+" ";
    }
}

public class Tree {
    // 前序遍历
    public void preOrderTraversal(Node root){
        System.out.print(root);
        if(root.left != null){
            preOrderTraversal(root.left);
        }
        if(root.right != null){
            preOrderTraversal(root.right);
        }
    }
    // 中序遍历
    public void inOrderTraversal(Node root){
        if(root.left != null){
            inOrderTraversal(root.left);
        }
        System.out.print(root);
        if(root.right != null){
            inOrderTraversal(root.right);
        }
    }
    // 后序遍历
    public void postOrderTraversal(Node root){
        if(root.left != null){
            postOrderTraversal(root.left);
        }
        if(root.right != null){
            postOrderTraversal(root.right);
        }
        System.out.print(root);
    }
    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        size++;
        if(root.left != null){
            getSize1(root.left);
        }
        if(root.right != null){
            getSize1(root.right);
        }
    }
    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root == null){
            return 0;
        }else{
            int rootSize = 1;
            int rootLeftSize = getSize2(root.left);
            int rootRightSize = getSize2(root.right);
            return rootSize+rootLeftSize+rootRightSize;
        }
    }
    // 遍历思路-求叶子结点个数
    public static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        if(root.left != null){
            getSize1(root.left);
        }
        if(root.right != null){
            getSize1(root.right);
        }
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if(root == null){
            return 0;
        } else {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                int leftLeaf = getLeafSize2(root.left);
                int rightLeaf = getLeafSize2(root.right);
                return leftLeaf + rightLeaf;
            }
        }
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if(root == null) {
            return 0;
        }
        if(k == 1){
            return 1;
        }else{
            int kLeftLevel = getKLevelSize(root.left,k-1);
            int kRightLevel = getKLevelSize(root.right,k-1);
            return kLeftLevel+kRightLevel;
        }
    }
}
