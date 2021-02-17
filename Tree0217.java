import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
