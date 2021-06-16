package cometrue;

public class BinarySearchTree {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    private TreeNode root = null;

    /**
     * 在搜索树中查找 key，如果找到，返回 key 所在的结点，否则返回 null
     *
     * @param key
     * @return null 表示没有查询到，非null表示查询到该节点
     */
    public TreeNode search(int key) {
        TreeNode node = root;
        while (node != null) {
            if (key == node.key) {
                return node;
            } else if (key > node.key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * 插入
     *
     * @param key
     * @return true 表示插入成功, false 表示插入失败
     */
    public boolean insert(int key) {
        if(root == null){
            root = new TreeNode(key);
            return true;
        }
        TreeNode parent = null;
        TreeNode node = root;
        while(node != null){
            if(key == node.key){
                return false;
            }else if(key < node.key){
                parent = node;
                node = node.left;
            }else {
                parent = node;
                node = node.right;
            }
        }
        if(key < parent.key){
            parent.left = new TreeNode(key);
        }else{
            parent.right = new TreeNode(key);
        }
        return true;
    }

    /**
     * 删除
     *
     * @param key
     * @return true成功返回 ，false失败返回
     */
    public boolean remove(int key) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (key == cur.key) {
                break;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }

        if(cur == null){
            return false;
        }

        if(parent == null){
            TreeNode n = cur.right;
            while(n.left != null){
                n = n.left;
            }
            n.left = cur.left;
            return true;
        }

        if(cur.left == null && cur.right == null){
            if(key < parent.key){
                parent.left = null;
            }else{
                parent.right = null;
            }
            return true;
        }

        if(cur.left != null && cur.right != null){
            TreeNode node = cur.right;
            while(node.left != null){
                node = node.left;
            }
            node.left = cur.left;
            node.right = cur.right;
            if(key < parent.key){
                parent.left = node;
            }else{
                parent.right = node;
            }
            return true;
        }

        if(cur.left == null){
            if(cur == root){
                root = root.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else if(cur == parent.right){
                parent.right = cur.right;
            }
            return true;
        }

        if(cur == root){
            root = root.left;
        }else if(cur == parent.left){
            parent.left = cur.left;
        }else if(cur == parent.right){
            parent.right = cur.left;
        }
        return true;
    }
}
