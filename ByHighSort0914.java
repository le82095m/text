import java.util.Comparator;

public class ByHighSort implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        return o1.high - o2.high;
    }
}
