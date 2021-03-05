import java.util.*;

class TreeAndHigh{
    TreeNode node;
    Integer high;

    public TreeAndHigh(TreeNode node, Integer high) {
        this.node = node;
        this.high = high;
    }
}

public class Solution {
    /**
     *
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值
     * 那么中位数就是所有数值排序之后位于中间的数值
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
     *
     */
    private ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }
    public Double GetMedian() {
        int size = list.size();
        if(size % 2 != 0){
            return (double) list.get(size/2);
        }else{
            return ((double)(list.get(size/2)+(double)list.get(size/2-1))/2);
        }
    }


    /**
     *
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     */

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeAndHigh> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        queue.add(new TreeAndHigh(pRoot,0));
        while (!queue.isEmpty()){
            TreeAndHigh tah = queue.remove();
            TreeNode node = tah.node;
            int index = tah.high;
            if (index >= list.size()) {
                list.add(new ArrayList<>());
            }
            list.get(index).add(node.val);
            if(node.left != null){
                queue.add(new TreeAndHigh(node.left,index+1));
            }
            if(node.right != null){
                queue.add(new TreeAndHigh(node.right,index+1));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(i % 2 != 0){
                reverseList(list.get(i));
            }
        }
        return list;
    }
    private void reverseList(ArrayList<Integer> list){
        for(int i = 0; i <= (list.size()-1)/2; i++){
            int temp = list.get(i);
            list.set(i,list.get(list.size()-i-1));
            list.set(list.size()-i-1,temp);
        }
    }


    /**
     *
     *请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     *
     */

    //Insert one char from stringstream
    String str = "";
    Map<Character,Integer> map = new HashMap<>();
    public void Insert(char ch) {
        str += ch;
        int count = map.getOrDefault(ch,0);
        map.put(ch,++count);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char c : str.toCharArray()){
            if(map.getOrDefault(c,0) == 1){
                return c;
            }
        }
        return '#';
    }



    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        ArrayList<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.val == root2.val){
                list.add(node);
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        if(list.isEmpty()){
            return false;
        }
        for(TreeNode node : list){
            if(isSeamTree(node,root2)){
                return true;
            }
        }
        return false;
    }
    private boolean isSeamTree(TreeNode node,TreeNode root){
        if(root == null){
            return true;
        }
        if(node == null){
            return false;
        }
        if(node.val != root.val){
            return false;
        }
        boolean left = isSeamTree(node.left,root.left);
        boolean right = isSeamTree(node.right,root.right);
        return left && right;
    }


    public int GetUglyNumber_Solution(int index) {
        // 1,2,3,4,5,6,8,9,10,12,14,15,16,18,20
        // 1,2,3,5,4,6,10,6,9,15,8,12,20
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int n = 0;
        int count = 0;
        while(count < 1000*index){
            list.add(list.get(n)*2);
            list.add(list.get(n)*3);
            list.add(list.get(n)*5);
            n++;
            count++;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Set<Integer> set = new HashSet<>(list);
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return arrayList.get(index-1);
    }
}
