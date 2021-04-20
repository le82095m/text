import java.util.*;
class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String strA = "";
            String strB = "";
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == ' '){
                    strA = str.substring(0,i);
                    strB = str.substring(i+1,str.length());
                }
            }
            boolean is = solution(buildMap(strA),buildMap(strB));
            if(is){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean solution(Map<Character,Integer> mapA,Map<Character,Integer> mapB){
        Set<Character> set = mapB.keySet();
        for(char c : set){
            int countA = mapA.getOrDefault(c,0);
            int countB = mapB.getOrDefault(c,0);
            if(countA < countB){
                return false;
            }
        }
        return true;
    }
    public static Map<Character,Integer> buildMap(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            int count = map.getOrDefault(c,0);
            map.put(c,++count);
        }
        return map;
    }
}
