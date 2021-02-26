public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(new TreeNode(4));
        bst.insert(0);
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
//        bst.leavesOrder();
        for (int i = 0; i < 10; i++) {
//            if(i == 8){
//                continue;
//            }
            System.out.println("删除"+i+":"+bst.remove(i)+" ");
        }
        bst.inOrder();
    }
}
