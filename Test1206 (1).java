import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        String str2 = "he";
//        str2 = str2+"llo";
//        String str1 = "hello";
//        String str2 = "he"+new String("llo");
//        System.out.println(str1 == str2);
        GrayCode g = new GrayCode();
        System.out.println("通过的:" + Arrays.toString(g.getGray1(3)));
        System.out.println("自己的:" + Arrays.toString(g.getGray1(3)));
    }
    static class GrayCode {

        public String[] getGray1(int n) {
            int m = 1<<n;
            String[] r = new String[m];
            if(n==1){
                r[0] = "0";
                r[1] = "1";
                return r;
            }
            String[] temp = getGray1(n-1);
            int j = 0;
            for(int i = 0;i<m;i++){
                if(i<m/2){
                    r[i] = "0"+temp[j++];
                }else{
                    r[i] = "1"+temp[--j];
                }
            }
            return r;
        }

    }

//        public String[] getGray(int n) {
//            List<String> list = new ArrayList<>();
//            String str = "";
//            fun(n,list,str);
//            String[] s = new String[list.size()];
//            s = list.toArray(s);
////            int a = s.length/2;
////            int b = s.length-1;
////            while(a < b){
////                String temp = s[a];
////                s[a] = s[b];
////                s[b] = temp;
////                a++;
////                b--;
////            }
//            return s;
//        }
//        public List<String> fun(int n,List<String> list,String str){
//            if(n == 0){
//                list.add(str);
//            }
//            if(n > 0){
//                fun(n-1,list,str+"0");
//                fun(n-1,list,str+"1");
//            }
//            return list;
//        }
//    }
}
