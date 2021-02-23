import java.util.*;

public class Main0219 {
    public static void main(String[] args) {
//        int[] arr = new int[]{8,4,6,5,2,1,7,3,9};
//        int[] arr1 = new int[]{1,2,7,4,5,6,3,8};
//        Sort.downAdjust(arr1,arr1.length,2);
//        System.out.println(Arrays.toString(arr1));
////        Sort.heapify(arr1,arr1.length,2);
////        System.out.println(Arrays.toString(arr1));
//        Sort.buildDeque(arr,arr.length);
//        System.out.println(Arrays.toString(arr));
        System.out.println(FirstNotRepeatingChar(
                "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));

    }
    public static int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i),0);
            map.put(str.charAt(i),++count);
        }
        for(int i = 0; i < str.length(); i++){
            int num = map.getOrDefault(str.charAt(i),0);
            if(num == 1){
                return i;
            }
        }
        return -1;
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        List<Integer> preList = new ArrayList<>();
        for(int i : pre){
            preList.add(i);
        }
        List<Integer> inList = new ArrayList<>();
        for(int i : in){
            inList.add(i);
        }
        return build(preList,inList);
    }
    public TreeNode build(List<Integer> preList, List<Integer> inList){
        if(preList.isEmpty()){
            return null;
        }
        int v = preList.get(0);
        TreeNode root = new TreeNode(v);
        int preSize = inList.indexOf(v);
        List<Integer> preLeft = preList.subList(1,preSize+1);
        List<Integer> preRight = preList.subList(preSize+1,preList.size());
        List<Integer> inLeft = inList.subList(0,preSize);
        List<Integer> inRight = inList.subList(preSize+1,preList.size());
        root.left = build(preLeft,inLeft);
        root.right = build(preRight,inRight);
        return root;
    }
}
