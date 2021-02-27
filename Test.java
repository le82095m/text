public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(new TreeNode(14));
        System.out.println("删除的key不在BST中 :"+bst.remove(0));
        bst.insert(12);
        System.out.println("删除只有一个结点的BST :"+bst.remove(14));
        bst.insert(16);
        bst.insert(11);
        System.out.println("删除叶子，其是双亲的左孩子 :"+bst.remove(11));
        bst.insert(11);
        System.out.println("删除叶子，其是双亲的右孩子 :"+bst.remove(16));
        bst.insert(10);
        System.out.println("删除根，但根没有右孩子 :"+bst.remove(11));
        bst.insert(20);
        bst.insert(5);
        System.out.println("删除根一个没有右孩子的结点，其是双亲的左孩子 :"+bst.remove(10));
        bst.insert(25);
        System.out.println("删除根一个没有右孩子的结点，其是双亲的右孩子 :"+bst.remove(20));
        bst.insert(8);
        System.out.println("删除根一个没有走孩子的结点，其是双亲的左孩子 :"+bst.remove(5));
        bst.insert(15);
        System.out.println("删除根一个没有走孩子的结点，其是双亲的右孩子 :"+bst.remove(25));
        bst.remove(8);
        bst.remove(12);
        bst.remove(15);
        System.out.println("删除空树 :"+bst.remove(25));
    }
}
