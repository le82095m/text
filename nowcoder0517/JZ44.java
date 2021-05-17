package nowcoder;

import java.util.ArrayList;

public class JZ44 {
    /**
     *
     * 牛客最近来了一个新员工 Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上
     * 同事 Cat对 Fish写的内容颇感兴趣，有一天他向 Fish借来翻看，但却读不懂它的意思
     * 例如，“nowcoder. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了
     * 正确的句子应该是“I am a nowcoder.”
     *
     * */

    public String ReverseSentence(String str) {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        int i = 0;
        for(; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                String s = " ";
                s += str.substring(index,i);
                list.add(s);
                index = i+1;
            }
        }
        list.add(str.substring(index,i));
        StringBuilder newStr = new StringBuilder();
        for(int j = list.size()-1; j >=0; j--){
            newStr.append(list.get(j));
        }
        return newStr.toString();
    }
}
