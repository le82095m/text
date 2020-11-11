package work;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CountAnySay {
//    public String countAndSay(int n) {
//
//    }
    public String describe(String str){
        int count = 1;
        String arr = "";
        for(int i = 0; i < str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }else{
                arr += count +""+ i;
                count = 0;
            }
        }
        return arr;
    }
}
