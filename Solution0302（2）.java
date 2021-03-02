import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
    *
    * 实现一个函数用来判断字符串是否表示数值(包括整数和小数)
    * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值
    * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
    *
    */
    public boolean isNumeric (String str) {
        boolean hasPom = false;
        boolean hasPoint = false;
        boolean hasE = false;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            hasPom = true;
        }
        for(int i = 1; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                continue;
            }else if(c == 'E' || c == 'e'){
                if(!hasE && i != str.length()-1){
                    hasE = true;
                }else{
                    return false;
                }
            }else if(c == '.'){
                if(!hasPoint && !hasE){
                    hasPoint = true;
                }else{
                    return false;
                }
            }else if(c == '-' || c == '+'){
                if(str.charAt(i-1) != 'E' && str.charAt(i-1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }



    /**
     *
     *给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
     *
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){
            return null;
        }
        ArrayList<TreeNode> list = inOrder(pRoot);
        if(k > list.size() || k <= 0){
            return null;
        }
        return list.get(k-1);
    }
    ArrayList<TreeNode> inOrder(TreeNode pRoot){
        ArrayList<TreeNode> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        if(pRoot.left != null){
            list.addAll(inOrder(pRoot.left));
        }
        list.add(pRoot);
        if(pRoot.right != null){
            list.addAll(inOrder(pRoot.right));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        return list;
    }



    /**
     *
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *
     */
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length(); i++){
            char c = stones.charAt(i);
            int num = map.getOrDefault(c,0);
            map.put(c,++num);
        }
        int count = 0;
        for(int i = 0; i < jewels.length(); i++){
            count += map.getOrDefault(jewels.charAt(i),0);
        }
        return count;
    }




    /**
     *
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序
     *
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            int count = map.getOrDefault(s,0);
            map.put(s,++count);
        }
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue()-o1.getValue() != 0){
                    return o2.getValue()-o1.getValue();
                }else{
                    for (int i = 0; i <Math.min(o1.getKey().length(),
                            o2.getKey().length()) ; i++) {
                        if(o2.getKey().charAt(i) != o1.getKey().charAt(i)) {
                            return o1.getKey().charAt(i) - o2.getKey().charAt(i);
                        }
                    }
                    return o1.getKey().length()-o2.getKey().length();
                }
            }
        });
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list1.add(list.get(i).getKey());
        }
        return list1;
    }




    /**
     *
     *判断一个二叉树是否左右相等
     *
     */
    boolean isSeam(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        if(pRoot.left == null && pRoot.right == null){
            return true;
        }
        if(pRoot.left == null){
            return false;
        }
        if(pRoot.right == null){
            return false;
        }
        if(pRoot.left.val != pRoot.right.val){
            return false;
        }
        boolean left = isSeam(pRoot.left);
        boolean right = isSeam(pRoot.right);
        return left && right;
    }


    

    /**
     *
     *请实现一个函数，用来判断一棵二叉树是不是对称的
     *注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
     *
     */

    boolean isSymmetrical1(TreeNode pRoot) {
        TreeNode mRoot = mirrorTree(pRoot);
        return isMirror(pRoot,mRoot);
    }
    boolean isMirror(TreeNode pRoot,TreeNode mRoot){
        if(pRoot == null && mRoot == null){
            return true;
        }else if(pRoot == null){
            return false;
        }else if(mRoot == null){
            return false;
        }
        if(pRoot.val == mRoot.val){
            boolean left = isMirror(pRoot.left,mRoot.right);
            boolean right = isMirror(pRoot.right,mRoot.left);
            return left && right;
        }else{
            return false;
        }
    }
    TreeNode mirrorTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            mirrorTree(root.left);
        }
        if(root.right != null){
            mirrorTree(root.right);
        }
        return root;
    }
}