import java.util.*;
 class Solution {
    /*
     *1、计算出0~n直接n的因数k;
     *2、当 k 为奇数时,则找到一组符合要求的序列
     *3、k即为序列的中间数，总个数为 n/k 个
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
        if(sum > 1 && sum%2 != 0){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sum/2);
            list.add(sum/2+1);
            allList.add(list);
        }
        for (int i = 2; i < sum; i++) {
            if(sum % i == 0) {
                if(i % 2 != 0){
                    ArrayList<Integer> list = fun1(i, sum / i);
                    if(list.get(0) >= 0){
                        allList.add(list);
                    }
                }else if((sum/i) % 2 != 0){
                    ArrayList<Integer> list = fun2(i, sum / i);
                    if(list.get(0) >= 0){
                        allList.add(list);
                    }
                }
            }
        }
        allList.sort(new SampleComparator());
        return allList;
    }

    // 9 10 11 12 13 14 15 16
    private ArrayList<Integer> fun1(int k, int mid) {
        ArrayList<Integer> list = new ArrayList<>();
        int startIndex = mid-(k/2);
        int endIndex = mid+(k/2);
        for(int i = startIndex;i <=endIndex;i++){
            if(i != 0) {
                list.add(i);
            }
        }
        return list;
    }

    private ArrayList<Integer> fun2(int k, int mid){
        ArrayList<Integer> list = new ArrayList<>();
        int startIndex = mid/2-k+1;
        int endIndex = mid/2+k;
        for(int i = startIndex;i <=endIndex;i++){
            if(i != 0) {
                list.add(i);
            }
        }
        return list;
    }
    static class SampleComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return ((List<Integer>)o1).get(0)-((List<Integer>)o2).get(0);
        }
    }
}
