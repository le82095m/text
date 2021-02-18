import java.util.*;

class NodeAndLayer{
    TreeNode node;
    int layer;

    public NodeAndLayer(TreeNode node, int layer) {
        this.node = node;
        this.layer = layer;
    }
}

public class Tree {
    public static void leverOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    public static void layerNode(TreeNode root){
        if(root == null){
            return;
        }
        Queue<NodeAndLayer> queue = new LinkedList<>();
        int layer = 1;
        queue.add(new NodeAndLayer(root,layer));
        while(!queue.isEmpty()){
            NodeAndLayer nal = queue.remove();
            System.out.print(nal.layer+" "+nal.node+" ");
            if(nal.node.left != null){
                queue.add(new NodeAndLayer(nal.node.left,nal.layer+1));
            }
            if(nal.node.right != null){
                queue.add(new NodeAndLayer(nal.node.right,nal.layer+1));
            }
        }
    }
    public static boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.peek() != null){
            TreeNode node = queue.remove();
            queue.add(node.left);
            queue.add(node.right);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> leverOrder(TreeNode root){
        List<List<String>> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        Queue<NodeAndLayer> queue = new LinkedList<>();
        queue.add(new NodeAndLayer(root,1));
        while (!queue.isEmpty()){
            NodeAndLayer nal = queue.remove();
            if(nal.layer > list.size()){
                List<String> nodeList = new ArrayList<>();
                nodeList.add(nal.node.v);
                list.add(nodeList);
            }else{
                list.get(nal.layer-1).add(nal.node.v);
            }
            if(nal.node.left != null){
                queue.add(new NodeAndLayer(nal.node.left,nal.layer+1));
            }
            if(nal.node.right != null){
                queue.add(new NodeAndLayer(nal.node.right,nal.layer+1));
            }
        }
        return list;
    }
    public static TreeNode buildTree1(String[] preorder,String[] inorder){
        List<String> preList = new ArrayList<>(Arrays.asList(preorder));
        List<String> inList = new ArrayList<>(Arrays.asList(inorder));
        return buildTree2(preList,inList);
    }
    public static TreeNode buildTree2(List<String> preorder,
                                      List<String> inorder){
        if(preorder.isEmpty()){
            return null;
        }
        String rootVal = preorder.get(0);
        if(preorder.size() == 1){
            return new TreeNode(rootVal);
        }
        int preSize = inorder.indexOf(rootVal);
        List<String> preLeft = preorder.subList(1,preSize+1);
        List<String> preRight = preorder.subList(preSize+1,preorder.size());
        List<String> inLeft = inorder.subList(0,preSize);
        List<String> inRight = inorder.subList(preSize+1,preorder.size());
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree2(preLeft,inLeft);
        root.right = buildTree2(preRight,inRight);
        return root;
    }

    public static String tree2Str(TreeNode t){
        StringBuilder sb = new StringBuilder();
        return preOrder(sb,t).toString();
    }

    private static StringBuilder preOrder(StringBuilder sb, TreeNode root) {
        if(root == null){
            return null;
        }
        sb.append(root.v);
        if(root.left != null) {
            sb.append("(");
            preOrder(sb, root.left);
            sb.append(")");
        }
        if(root.right != null) {
            sb.append("(");
            preOrder(sb, root.right);
            sb.append(")");
        }
        return sb;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root){
            return root;
        }
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        if(pInLeft && qInLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!pInLeft && !qInLeft){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean search(TreeNode node, TreeNode p) {
        if(node == null){
            return false;
        }
        if(node == p){
            return true;
        }
        if(search(node.left,p)){
            return true;
        }
        return search(node.right, p);
    }
}
class solution{
    public TreeNode head;
    public TreeNode last;
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }
    private void tailAdd(TreeNode node) {
        if (head == null) {
            head = last = node;
        } else {
            last.right = node;
            node.left = last;
            last = last.right;
        }
    }
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        tailAdd(root);
        inOrder(root.right);
    }
}
