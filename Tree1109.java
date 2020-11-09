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
        if(root.left != null){
            return getSize2(root.left)+1;
        }
        if(root.right != null){
            return getSize2(root.right)+1;
        }
        return 0;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){

    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        return 0;
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root){
        return 0;
    }
}
