package WorkDemo;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
}
class Solution2 {
    public boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();
        while(x > 0){
            int temp = x % 10;
            list.add(temp);
            x /= 10;
        }
        int i = 0;
        int j = list.size()-1;
        while(i < j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
