import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        Teacher.ByHighComparator highComparator = new Teacher.ByHighComparator();
        Teacher.ByWightComparator wightComparator = new Teacher.ByWightComparator();
        Teacher ter1 = new Teacher("高博", 80, 170, 18);
        Teacher ter2 = new Teacher("高博", 80, 170, 18);
        Teacher ter3 = new Teacher("许之琛", 60, 180, 18);
        System.out.println(ter1.equals(ter2));
        System.out.println(highComparator.compare(ter1, ter3));
        System.out.println(wightComparator.compare(ter1, ter3));
    }
}

class Teacher implements Comparable<Teacher>{
    public Teacher(String name, int wight, int high, int age) {
        this.name = name;
        this.wight = wight;
        this.high = high;
        this.age = age;
    }
    String name;
    int wight;
    int high;
    int age;
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
        return false;
        if(! (obj instanceof Teacher)) {
            return false;
        }
        Teacher o = (Teacher) obj;
        return this.name.equals(o.name);
    }

    @Override
    public int compareTo(Teacher o) {
        return this.age - o.age;
    }
    static class ByHighComparator implements Comparator<Teacher>{
        @Override
        public int compare(Teacher o1, Teacher o2) {
            return o1.high - o2.high;
        }
    }
    static class  ByWightComparator implements Comparator<Teacher>{
        @Override
        public int compare(Teacher o1, Teacher o2) {
            return o1.wight - o2.wight;
        }
    }
}