import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    TreeNode root;
    public BinarySearchTree(TreeNode node) {
        root = node;
    }

    //查找
    public boolean search(int val){
        TreeNode node = root;
        while (node != null){
            if(val == node.key){
                return true;
            }else if(val < node.key){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return false;
    }

    //插入
    public void insert(int val){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            pre = cur;
            if(val == cur.key) {
                throw new RuntimeException("BinarySearchTree 中不允许有重复结点");
            } else if(val < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        if(val < pre.key){
            pre.left = new TreeNode(val);
        }else{
            pre.right = new TreeNode(val);
        }
    }

    public boolean remove1(int val){
        if(root == null){
            return false;
        }
        TreeNode cur = root;
        TreeNode oldPre = null;
        int cmp = val - cur.key;
        while (cur != null){
            cmp = val - cur.key;
            if(cmp == 0){
                break;
            }else if(cmp < 0){
                oldPre = cur;
                cur = cur.left;
            }else{
                oldPre = cur;
                cur = cur.right;
            }
        }
        if(cur == null){
            return false;
        }
        TreeNode node = cur.left;
        TreeNode pre = null;
        while (cur != null){
            pre = cur;
            cur = cur.right;
        }
        pre.right = node;
        if(oldPre != null){
            if(cmp < 0){
                oldPre.left = pre;
            }else{
                oldPre.right = pre;
            }
        }
        return true;
    }

    public boolean remove(int val){
        if(root == null){
            return false;
        }
        TreeNode per = null;
        TreeNode cur = root;
        while (cur != null){
            if(val == cur.key){
                break;
            }else if(val < cur.key){
                per = cur;
                cur = cur.left;
            }else{
                per = cur;
                cur = cur.right;
            }
        }
        if(cur == null){
            return false;
        }
        //第一种:该树只有一个结点，且根即为要删除的数
        if(per == null && cur.left == null && cur.right == null){
            root = null;
            return true;
        }
        //第二种:找到该结点为叶子接结点
        if(cur.left == null && cur.right == null){
            if(val < per.key){
                per.left = null;
            }else{
                per.right = null;
            }
            return true;
        }
        //第三种:找的结点只有一个孩子
        if(cur.left != null && cur.right == null){
            if(per == null){
                root = cur.left;
                return true;
            }
            if(cur.left.key < per.key){
                per.left = cur.left;
            }else{
                per.right = cur.left;
            }
            return true;
        }else if(cur.left == null){
            if(per == null){
                root = cur.right;
                return true;
            }
            if(cur.right.key < per.key){
                per.left = cur.right;
            }else{
                per.right = cur.right;
            }
            return true;
        }else {
            //第四种:找的结点有两个孩子
            TreeNode node = cur.left;
            TreeNode preNode = cur;
            while (node.right != null) {
                preNode = node;
                node = node.right;
            }
            int temp = node.key;
            node.key = cur.key;
            cur.key = temp;
            if(preNode.key != val){
                preNode.right = null;
            }else{
                cur.left = null;
            }
            return true;
        }
    }
    public void inOrder(){
        inOrderFun(root);
    }
    private void inOrderFun(TreeNode node){
        if(node == null){
            return;
        }
        inOrderFun(node.left);
        System.out.print(node.key+" ");
        inOrderFun(node.right);
    }
    public void leavesOrder(){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == null){
                System.out.print("null ");
            }else{
                System.out.print(node.key+" ");
            }
            if(node != null && (node.left != null || node.right != null)) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }
}
