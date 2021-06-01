package newcodes;

import java.util.ArrayList;

public class JZ57 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
        public static boolean is = false;
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if(pNode == null){
                return null;
            }
            TreeLinkNode root = pNode;
            while(root.next != null){
                root = root.next;
            }
            ArrayList<TreeLinkNode> list = midPrint(root);
            int index = list.indexOf(pNode)+1;
            if(index == list.size()){
                return null;
            }
            return list.get(index);
        }
        public ArrayList<TreeLinkNode> midPrint(TreeLinkNode root){
            ArrayList<TreeLinkNode> list = new ArrayList<>();
            if(root.left != null){
                list.addAll(midPrint(root.left));
            }
            list.add(root);
            if(root.right != null){
                list.addAll(midPrint(root.right));
            }
            return list;
        }
}
