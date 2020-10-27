package Tree;

import Tree.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(8);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = e;
        b.right = d;
        c.left = f;
        d.left = g;
        function fun = new function();
//        fun.printTree1(a);
//        System.out.println();
//        fun.printTree2(a);
//        System.out.println();
//        fun.printTree3(a);
          fun.getSize(a);
        System.out.println(fun.size);
    }
}
