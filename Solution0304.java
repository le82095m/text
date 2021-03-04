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



    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        order(root);
        return lists;
    }
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<Integer> order(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root != null){
            list.add(root.val);
        }
        if(root.left != null){
            list.addAll(order(root.left));
        }
        lists.add(list);
        if(root.right != null){
            list.addAll(order(root.right));
        }
        lists.add(list);
        return list;
    }
}
