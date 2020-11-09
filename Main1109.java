public class Main {
    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        Node node9 = new Node("I");
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        Tree tree = new Tree();
        tree.preOrderTraversal(node1);
        System.out.println();
        tree.inOrderTraversal(node1);
        System.out.println();
        tree.postOrderTraversal(node1);
        tree.getSize1(node1);
        System.out.println(tree.getSize2(node1));
    }
}
