import java.util.*;
public class Main{
    /**
     *
     *12
     * 4873279
     * ITS-EASY
     * 888-4567
     * 3-10-10-10
     * 888-GLOP
     * TUT-GLOP
     * 967-11-11
     * 310-GINO
     * F101010
     * 888-1200
     * -4-8-7-3-2-7-9-
     * 487-3279
     * 4
     * UTT-HELP
     * TUT-GLOP
     * 310-GINO
     * 000-1213
     *
     */
    private static Map<Character,Integer> map = new HashMap<>();
    public static void main(String[] args){
        buildMap();
//        System.out.println(fun("4873279"));
        System.out.println(fun("ITS-EASY"));
        System.out.println(fun("3-10-10-10"));
        System.out.println(fun("888-GLOP"));
        System.out.println(fun("-4-8-7-3-2-7-9-"));
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            Set<String> set = new HashSet<>();
//            for(int i = 0 ; i < num ; i++){
//                String str = fun(sc.nextLine());
//                if(set.add(str)){
//                    System.out.println(str);
//                }
//            }
//        }
    }
    public static String fun(String str){
        StringBuffer sb = new StringBuffer(str);
        while(true){
            int num = sb.indexOf("-");
            if(num <= -1){
                break;
            }
            sb.deleteCharAt(num);
        }
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.deleteCharAt(i);
                sb.insert(i,('0'+map.get(c)));
            }
        }
        sb.insert(3,'-');
        return sb.toString();
    }
    public static void buildMap(){
        int count = 2;
        for(char i = 'A'; i <= 'R' ; i++){
            if((i-'A'+1) % 3 == 0){
                count++;
            }
            map.put(i,count);
        }
        map.put('S',7);
        map.put('T',8);
        map.put('U',8);
        map.put('V',8);
        map.put('W',9);
        map.put('X',9);
        map.put('Y',9);
        map.put('Z',9);
    }
}