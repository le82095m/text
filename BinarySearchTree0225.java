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

    public boolean remove(int val){
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
}
