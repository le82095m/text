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
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : array){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
        }
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> e : set){
            if(e.getValue() > (array.length/2)){
                return e.getKey();
            }
        }
        return 0;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length){
            return list;
        }
        Arrays.sort(input);
        for(int i = 0 ;i < k;i++){
            list.add(input[i]);
        }
        return list;
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }
        int j = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i < pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
            if(j == popA.length){
                return true;
            }
        }
        return false;
    }
    public int GetNumberOfK(int [] array , int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : array){
            int count = map.getOrDefault(num,0);
            map.put(num,++count);
        }
        return map.getOrDefault(k,0);
    }
    public String PrintMinNumber(int [] numbers){
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < numbers.length;i++){
            list.add(numbers[i]+"");
        }
        while(!list.isEmpty()){
            String s = list.get(0);
            for(String str : list){
                if(compare(str,s)){
                    s = str;
                }
            }
            res += s;
            list.remove(s);
        }
        return res;
    }
    public static boolean compare(String s1,String s2){
        int i = 0;
        while(i < s1.length() && i < s2.length()){
            if(s1.charAt(i) < s2.charAt(i)){
                return true;
            }
            i++;
        }
        if(i < s1.length() && i == s2.length()){
            int j = i;
            while(j < s1.length()){
                if(s1.charAt(j) != s2.charAt(0)){
                    return s1.charAt(j) < s2.charAt(0);
                }else{
                    j++;
                }
            }
        }
        if(i < s2.length() && i == s1.length()){
            int j = i;
            while(j < s2.length()){
                if(s2.charAt(j) != s1.charAt(0)){
                    return s2.charAt(j) > s1.charAt(0);
                }else{
                    j++;
                }
            }
        }
        return false;
    }
}
