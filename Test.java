import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class people{
    String name;
    int num;
    public people(String name,int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<people> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new people(s.nextLine(), Integer.parseInt(s.nextLine())));
        }
        System.out.println(list);
    }
}
