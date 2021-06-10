public class NC103 {
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        int start = 0;
        int end = str.length()-1;
        char[] chars = str.toCharArray();
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        StringBuilder s = new StringBuilder();
        for(char c : chars){
            s.append(c);
        }
        return s.toString();
    }
}
