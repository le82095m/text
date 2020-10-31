import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String args[])throws IOException {
        String st = "hello ward";
        String[] strA = st.split(" ");
//        System.out.println(strA);
        String s1 = "acb";
        int num = 0;
        for(int i = 0;i < s1.length();i++){
            num += s1.charAt(i);
        }
//        HashSet<Character> set = new HashSet<>();
//        for(Character s : s1){
//            set.add(s);
//        }
//        System.out.println(num);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int str = Integer.parseInt(br.readLine());
//        String[] strs = br.readLine().split(" ");
//        List<Integer> list = new ArrayList<>();
//        try{
//            for(String s : strs){
//                if(!list.contains(s)){
//                    list.add(Integer.parseInt(s));
//                }
//            }
//        }catch (Exception e){
//
//        }
//        Collections.sort(list);
//        StringBuffer sb = new StringBuffer();
//        for(Integer t : list){
//            sb.append(t).append(" ");
//        }
//        System.out.println(sb.toString().trim());

        class Solution {
            public boolean CheckPermutation(String s1, String s2) {
                return fun1(s1) == fun1(s2) && fun2(s1)==fun2(s2);
            }
            public int fun1(String s1){
                int num = 0;
                for(int i = 0;i < s1.length();i++){
                    num += s1.charAt(i);
                }
                return num;
            }
            public int fun2(String s1){
                HashSet<Character> set = new HashSet<>();
                for(int i = 0;i < s1.length();i++){
                    set.add(s1.charAt(i));
                }
                return set.size();
            }
        }


        Map<Character,Integer> map1 = new TreeMap<>();
        map1.put('a',3);
        map1.put('b',4);
        map1.put('c',5);
        map1.put('d',6);
        Map<Character,Integer> map2 = new TreeMap<>();
        map2.put('c',5);
        map2.put('a',3);
        map2.put('d',5);
        map2.put('b',4);
        String str = "abcdefg";
        char[] c = str.toCharArray();
        char[] a = Arrays.copyOf(c,2);
        System.out.println(a);

    }

    class Solution {
        public String replaceSpaces(String S, int length) {
            char[] a = S.toCharArray();
            char[] newStr = new char[length*3];
            int count = 0;
            for(int i = 0; i < length ;i++){
                if(a[i] != (' ')){
                    newStr[i+count] = S.charAt(i);
                }else{
                    newStr[i] = '%';
                    newStr[i+1] = '2';
                    newStr[i+2] = '0';
                    count+=2;
                }
            }
            String s = new String(newStr);
            return s;
        }
    }
}
