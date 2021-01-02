import java.util.ArrayList;

class treeNOde{
    int val;
    treeNOde left;
    treeNOde right;
}
public class Tree {
    public static boolean found(treeNOde root,treeNOde node){
        if(root == null){
            return false;
        }
        if(root == node){
            return true;
        }
        boolean b = found(root.left,node);
        if(b){
            return true;
        }
        return found(root.right,node);
    }
    public static ArrayList<treeNOde> qianxu(treeNOde root) {
        ArrayList<treeNOde> list = new ArrayList<>();
        if (root != null) {
            list.add(root);
            ArrayList<treeNOde> leftList = qianxu(root.left);
            list.addAll(leftList);
            ArrayList<treeNOde> rightList = qianxu(root.right);
            list.addAll(rightList);
        }
    }
    public static ArrayList<treeNOde> zhongxu(treeNOde root){
        ArrayList<treeNOde> list = new ArrayList<>();
        if(root != null){
            ArrayList<treeNOde> leftList = zhongxu(root.left);
            list.addAll(leftList);
            list.add(root);
            ArrayList<treeNOde> rightList = zhongxu(root.right);
            list.addAll(rightList);
        }
    }
}
