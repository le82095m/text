import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> list = new ArrayList<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            for(int i = 0; i < str.length();i++){
                list.add(str.charAt(i));
            }
            TreeNode root = fun(list);
        }
    }
    public static void order(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.v);
        order(root.left);
        order(root.right);
    }
    public static TreeNode fun(List<Character> in) {
        if (in == null) {
            return null;
        }
        char v = in.remove(0);
        if (v == '#') {
            return null;
        }
        TreeNode node = new TreeNode(v + "");
        TreeNode leftNode = fun(in);
        TreeNode rightNode = fun(in);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
