package solution;

public class NC29 {
    public boolean searchMatrix (int[][] matrix, int target) {
        int i = 0;
        for(; i < matrix.length; i++){
            if(target < matrix[i][0]){
                i--;
                break;
            }
        }
        if(i == -1){
            return false;
        }
        if(i == matrix.length){
            i--;
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(target == matrix[i][j]){
                return true;
            }
        }
        return false;
    }
}
