package Tree;

public class function {
    //前序遍历
    public  void printTree1(TreeNode root){
        if(root!=null){
            System.out.print(root);
            printTree1(root.left);
            printTree1(root.right);
        }
    }
    //中序遍历
    public  void printTree2(TreeNode root){
        if(root != null){
            printTree2(root.left);
            System.out.print(root);
            printTree2(root.right);
        }
    }
    //后序遍历
    public  void printTree3(TreeNode root){
        if(root != null){
            printTree3(root.left);
            printTree3(root.right);
            System.out.print(root);
        }
    }
    // 遍历思路-求结点个数
    public int size = 0;
    public void getSize(TreeNode root){
        if(root != null){
            size++;
            getSize(root.left);
            getSize(root.right);
        }
    }
}
