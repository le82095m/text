import java.util.Comparator;

public class ByAgeSort implements Comparator<People> {

    @Override
    public int compare(People o1, People o2) {
        return o1.age - o2.age;
    }
}
