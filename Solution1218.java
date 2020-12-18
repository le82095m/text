import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int startIndex = 0;
        int endIndex = array.length-1;
        while(startIndex < endIndex){
            if(array[startIndex]+array[endIndex] > sum){
                endIndex--;
            }else if(array[startIndex]+array[endIndex] < sum){
                startIndex++;
            }else{
                int a = array[startIndex];
                int b = array[endIndex];
                if(list.isEmpty()){
                    list.add(array[startIndex]);
                    list.add(array[endIndex]);
                }else{
                    if(a*b < list.get(0) * list.get(1)){
                        list.clear();
                        list.add(a);
                        list.add(b);
                    }
                    startIndex++;
                    endIndex--;
                }
            }
        }
        return list;
    }
}