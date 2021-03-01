import java.util.ArrayList;


public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        // [ 1, 2, 3, 4]
        // [12,13,14, 5]
        // [11,16,15, 6]
        // [10, 9, 8, 7]
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        int left = 0;
        int up = 0;
        while(true){
            for(int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
            if(++up > down){
                break;
            }
            for(int i = up; i <= down; i++){
                list.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            for(int i = right; i >= left; i--){
                list.add(matrix[down][i]);
            }
            if(--down < up){
                break;
            }
            for(int i = down; i >= up ; i--){
                list.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }
        return list;
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null){
            return false;
        }
        return function1(sequence,0,sequence.length-1);
    }
    public boolean function1(int[] arr,int start,int end){
        if(start >= end){
            return true;
        }
        int root = arr[end];
        int i = start;
        for(;i < end; i++) {
            if (arr[i] > root) {
                break;
            }
        }
        int j = i;
        for(;j < end; j++){
            if(arr[j] < root){
                return false;
            }
        }
        boolean left = function1(arr,start,i-1);
        boolean right = function1(arr,i,end-1);
        return left && right;
    }
    public ArrayList<Integer> preOrder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root != null){
            list.add(root.v);
        }
        if(root.left != null) {
            list.addAll(preOrder(root.left));
        }
        if(root.right != null) {
            list.addAll(preOrder(root.right));
        }
        return list;
    }
}
