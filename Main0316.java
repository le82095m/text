import java.util.*;
public class Main{
    private static Map<Character,Integer> map = new HashMap<>();
    public static void main(String[] args){
        buildMap();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Set<String> set = new HashSet<>();
            for(int i = 0; i < num; i++){
                String str = fun(sc.next());
                set.add(str);
            }
            ArrayList<String> list = new ArrayList<>(set);
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return o1.length() - o2.length();
                }
            });
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
    public static String fun(String str){
        str = str.replace("-","");
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                char a = (char) ('0'+map.get(c));
                str = str.replace(c+"",a+"");
            }
        }
        StringBuffer sb = new StringBuffer(str);
        if(str.length() == 7){
            sb.insert(3,'-');
        }
        return sb.toString();
    }
    public static void buildMap(){
        int count = 1;
        for(char i = 'A'; i <= 'R' ; i++){
            if((i-'A') % 3 == 0){
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