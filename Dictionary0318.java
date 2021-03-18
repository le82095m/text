import java.util.*;
class Word{
    String str;
    Map<Character,Integer> map = new HashMap<>();

    public Word(String str) {
        this.str = str;
        for(char c : str.toCharArray()){
            int count = this.map.getOrDefault(c,0);
            this.map.put(c,++count);
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "str='" + str + '\'' +
                '}';
    }
}

public class Dictionary {
    private static List<List<Word>> dictionary = new ArrayList<>();
    public static void main(String[] args) {
        add("abcd");
        add("abdc");
        add("abe");
        add("bdca");
        List<String> list = brotherWordSize("abcd");
        for(String s : list){
            System.out.print(s+" ");
        }
    }
    public static void add(String str){
        List<Word> words = new ArrayList<>();
        Word word = new Word(str);
        words.add(word);
        if(dictionary.size() == 0){
            dictionary.add(words);
            return;
        }
        for(List<Word> list : dictionary){
            if(list.get(0).str.length() == str.length()){
                list.add(word);
                list.sort(new Comparator<Word>() {
                    @Override
                    public int compare(Word o1, Word o2) {
                        for(int i = 0;i < Math.min(o1.str.length(),o2.str.length());i++){
                            if(o1.str.charAt(i) != o2.str.charAt(i)){
                                return o1.str.charAt(i) - o2.str.charAt(i);
                            }
                        }
                        return o2.str.length()-o1.str.length();
                    }
                });
                return;
            }
        }
        dictionary.add(words);
        dictionary.sort(new Comparator<List<Word>>() {
            @Override
            public int compare(List<Word> o1, List<Word> o2) {
                return o1.get(0).str.length() - o2.get(0).str.length();
            }
        });
    }
    public static List<String> brotherWordSize(String str){
        Word word = new Word(str);
        List<String> arrayList = new ArrayList<>();
        for(List<Word> list : dictionary){
            if(list.get(0).str.length() == str.length()){
                for(Word w : list){
                    if(isBrother(w,word)){
                        arrayList.add(w.str);
                    }
                }
                break;
            }
        }
        arrayList.remove(str);
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < Math.min(o1.length(),o2.length()); i++) {
                    if(o1.charAt(i) != o2.charAt(i)){
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return o2.length()-o1.length();
            }
        });
        return arrayList;
    }
    public static boolean isBrother(Word wA,Word wB){
        return wA.map.equals(wB.map);
    }
}