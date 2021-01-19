import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class User{
    String name;
    int score;
    public User(String name,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}
public class Score {
    public static void main(String[] args){
        List<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0 ;i < 3;i++){
            String str = sc.nextLine();
            User u = new User(str,Integer.parseInt(sc.nextLine()));
            list.add(u);
        }
        list.sort(new SampleComparator());
        System.out.println(list.toString());
    }
    static class SampleComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return ((User)o2).score-((User)o1).score;
        }
    }
}
