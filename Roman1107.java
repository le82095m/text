package leetCode;

class Solution2 {
    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0; i < s.length();i++){
            switch(s.charAt(i)){
                case 'I':
                    if(i != s.length()-1 && s.charAt(i+1) == 'V'){
                        num += 4;
                        i++;
                    }else if(i != s.length()-1 && s.charAt(i+1) == 'X'){
                        num += 9;
                        i++;
                    }else{
                        num += exchange('I');
                    }
                    break;
                case 'X':
                    if(i != s.length()-1 && s.charAt(i+1) == 'L'){
                        num += 40;
                        i++;
                    }else if(i != s.length()-1 && s.charAt(i+1) == 'C'){
                        num += 90;
                        i++;
                    }else{
                        num += exchange('X');
                    }
                    break;
                case 'C':
                    if(i != s.length()-1 && s.charAt(i+1) == 'D'){
                        num += 400;
                        i++;
                    }else if(i != s.length()-1 && s.charAt(i+1) == 'M'){
                        num += 900;
                        i++;
                    }else{
                        num += exchange('C');
                    }
                    break;
                default:
                    num += exchange(s.charAt(i));
                    break;
            }
        }
        return num;
    }
    public int exchange(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
