package Soultion;

import java.util.ArrayList;
import java.util.Comparator;

 class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

     @Override
     public String toString() {
         return "["+ start + ","+ end + "]";
     }
 }

public class NC37 {
     /**
      *
      *给出一组区间，请合并所有重叠的区间。
      *请保证合并后的区间按区间起点升序排列。
      *
      * 输入：
      * [[10,30],[20,60],[80,100],[150,180]]
      * 返回值：
      * [[10,60],[80,100],[150,180]]
      *
      * */
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1,4));
        list.add(new Interval(0,0));
        list.add(new Interval(2,2));
        list.add(new Interval(3,3));
//        list.add(new Interval(3,5));
//        list.add(new Interval(0,1));
        ArrayList<Interval> l = merge(list);
        for (Interval i : l){
            System.out.print(i.toString()+" ");
        }
    }


    public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
        if(intervals.size() < 2){
            return intervals;
        }
        intervals.sort(new Comparator<Interval>(){
            @Override
            public int compare(Interval i1,Interval i2){
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                }else{
                    return i1.end - i2.end;
                }
            }
        });
        int index = 0;
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
//        while(index < intervals.size()) {
//            if(intervals.get(index).start != intervals.get(index).end) {
//                list.add(intervals.get(index));
//                break;
//            }
//            index++;
//        }
//        if(index >= intervals.size()){
//            return list;
//        }
        int length = 1;
        for(int i = 1; i < intervals.size(); i++){
            Interval i1 = list.get(length-1);  //[0,0]
            Interval i2 = intervals.get(i);    //[1,4]
            if(i1.end < i2.start){
                list.add(i2);
                length++;
            }else{
                if(i1.end > i2.end){
                }else{
                    list.remove(list.size()-1);
                    list.add(new Interval(i1.start,i2.end));
                }
            }
        }
//        Interval i1 = list.get(list.size()-1);          //[0,4]
//        Interval i2 = intervals.get(intervals.size()-1);//[3,5]
//        if(i1.end < i2.start){
//            list.add(i2);
//        }else{
//            if(i1.end > i2.end){
//            }else{
//                if(i1.start < i2.start && i1.end < i2.end) {
//                    list.remove(list.size()-1);
//                    list.add(new Interval(i1.start, i2.end));
//                }
//            }
//        }
        return list;
    }
}
