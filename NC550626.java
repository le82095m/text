package Soultion;

import java.util.*;


class Solution {
    /**
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        if(strs.length == 0){
            return "";
        }
        ArrayList<Set<Character>> list = new ArrayList<>();
        int min = strs[0].length();
        for(String s : strs){
            if(s.length() == 0){
                return "";
            }
            if(s.length() < min){
                min = s.length();
            }
            for(int i = 0; i < s.length(); i++){
                if(i > list.size()-1){
                    Set<Character> set = new HashSet<>();
                    set.add(s.charAt(i));
                    list.add(set);
                }else{
                    list.get(i).add(s.charAt(i));
                }
            }
        }
        StringBuilder s = new StringBuilder();
        for(Set set : list){
            if(min <= 0){
                break;
            }
            if(set.size() > 1){
                break;
            }else{
                s.append((set.toArray(new Object[0]))[0]);
            }
            min--;
        }
        return s.toString();
    }
}
