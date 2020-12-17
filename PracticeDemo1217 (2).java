import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Test {
    public static void main(String[] args) {
//      System.out.println(uglyNumber(1));
//        System.out.println(isUglyNumber(8));
      System.out.println(singleString("olrangeo"));
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
//        t1.right = t2;
//        t1.left = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
//        t4.left = t8;
//        t4.right = t9;
//        System.out.println(deepTree(t1));
    }
    //把只包含质因子2、3和5的数称作丑数（Ugly Number）
    // 例如6、8都是丑数，但14不是，因为它包含质因子7
    // 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public static int uglyNumber(int n){
        int i = 1;
        while(n > 0) {
            if (isUglyNumber(i)) {
                n--;
            }
            i++;
        }
        return i-1;
    }
    public static boolean isUglyNumber(int num){
        for (int i = 2; i <= num;i++){
                if(num % i == 0){
                    if(i % 2 != 0 && i % 3 != 0 && i % 5 !=0){
                        return false;
                    }
                }
            }
        return true;
    }

    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
    // 并返回它的位置, 如果没有则返回-1（需要区分大小写）.（从0开始计数）
    public static String singleString(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i),0);
            map.put(str.charAt(i),++count);
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        for (Map.Entry<Character,Integer> e : set){
            if(e.getValue() == 1){
                char c =  e.getKey();
                return str.indexOf(c+"")+"";
            }
        }
        return "-1";
    }


    //在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
    //对于50\%50%的数据,size\leq 10^4size≤10^4
    //对于75\%75%的数据,size\leq 10^5size≤10^5
    //对于100\%100%的数据,size\leq 2*10^5size≤2∗10^5

    //输入一棵二叉树，求该树的深度。
    //从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    public static int deepTree(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return deepTree(root.left)+deepTree(root.right);
    }
    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
}
