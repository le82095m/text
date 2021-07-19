package nowcoder;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class JZ61 {
    public static void main(String[] args) {
        JZ61 j = new JZ61();
        TreeNode root = j.buildTree();
        System.out.println(j.Serialize(root).trim());
        TreeNode node = j.Deserialize("8 6 10 5 7 9 11");
        System.out.println(j.Serialize(node).trim());
    }

    TreeNode buildTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        return node1;
    }

    String Serialize(TreeNode root) {
        String str = "";
        if (root == null) {
            str += "# ";
        } else {
            str += root.val + " ";
        }
        if (root != null) {
            str += Serialize(root.left);
            str += Serialize(root.right);
        }
        return str;
    }

    TreeNode Deserialize(String str) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> stack = new LinkedList<>();
        boolean is = true;
        TreeNode root = null;

        String[] split = str.split(" ");
        for (String s : split) {
            int num = 0;
            if(!s.contentEquals("#")) {
                for (int i = 0; i < s.length(); i++) {
                    num += (s.charAt(s.length() - 1 - i) - '0') * (int) Math.pow(10, i);
                }
            }else{
                num = '#';
            }
            TreeNode node = new TreeNode(num);

            if(node.val != '#'){
                map.put(node,2);
            }
            if(is) {
                root = node;
                is = false;
            }
            if(!stack.isEmpty()){
                TreeNode top = stack.peek();
                if(map.get(top) == 2) {
                    if(node.val != '#'){
                        top.left = node;
                    }
                    map.put(top,1);
                }else if(map.get(top) == 1){
                    if(node.val != '#'){
                        top.right = node;
                    }
                    map.put(top,0);
                    stack.pop();
                }
            }
            if(node.val != '#') {
                stack.push(node);
            }
        }
        return root;
    }
}
