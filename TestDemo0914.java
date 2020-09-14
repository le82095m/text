import java.util.Arrays;
import java.util.Comparator;

class People {
    public String name;
    public int age;
    public int high;
    public int weight;

    public People(String name, int age, int high, int weight) {
        this.name = name;
        this.age = age;
        this.high = high;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", high=" + high +
                ", weight=" + weight +
                '}';
    }
}
public class TestDemo {
    public static <T> void sort(T[] arr, Comparator<T> comparator){
        for(int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length-1 ; j++) {
                int r = comparator.compare(arr[j],arr[j+1]);
                if(r > 0){
                    T t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        People[] peoples = {new People("张三",18,180,80),
                            new People("李四",19,175,75),
                            new People("王五",20,178,81),
                            new People("梅六",33,170,70),
        };
        ByAgeSort byAgeSort = new ByAgeSort();
        ByHighSort byHighSort = new ByHighSort();
        sort(peoples,byAgeSort);
        System.out.println(Arrays.toString(peoples));
        sort(peoples,byHighSort);
        System.out.println(Arrays.toString(peoples));
    }
}