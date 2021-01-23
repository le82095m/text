import java.util.*;
class Results{
    String ifContains;
    int num;
    public Results(String s,int num){
        this.ifContains = s;
        this.num = num;
    }

    @Override
    public String toString() {
        return ifContains +" "+ num;
    }
}
class Main1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str){
            list.add(c);
        }
        char[] arr = sc.nextLine().toCharArray();
        System.out.println(judge(list, arr));
    }
    public static Results judge(ArrayList<Character> str,char[] arr){
        int count = 0;
        String s = "Yes";
        for(char c : arr){
            if(str != null && str.contains(c)){
               str.remove((Character) c);
            }else{
                count++;
                s = "No";
            }
        }
        if(s.equals("Yes")){
            return new Results(s,str.size());
        }else{
            return new Results(s,count);
        }
    }
}
