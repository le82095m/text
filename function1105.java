package WorkDemo;

class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return null;
        }
        int max = 0;
        int beginIndex = 0;
        int endIndex = 0;
        for(int j = 0 ; j < s.length() ; j++){
            for(int i = s.length() - 1;i >= j;i--){
                int first = j;
                int end = i;
                while(true){
                    char a = s.charAt(first);
                    char b = s.charAt(end);
                    if(a != b){
                        break;
                    }else if(first == end || first+1 == end){
                        int size = i - j+1;
                        if(max < size){
                            beginIndex = j;
                            endIndex = i;
                            max = size;
                        }
                        break;
                    }else{
                        first++;
                        end--;
                    }
                }
            }
        }
        System.out.println(beginIndex +"" +endIndex);
        return s.substring(beginIndex,endIndex+1);
    }
}
