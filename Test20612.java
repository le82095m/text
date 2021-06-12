class People implements Comparable{
    String name;
    int age;
    int high;
    int wight;

    public People(String name, int age, int high, int wight) {
        this.name = name;
        this.age = age;
        this.high = high;
        this.wight = wight;
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((People)o).age;
    }
}
public class Test2 {
    public static void main(String[] args) {
        People people1 = new People("张三",18,175,80);
        People people2 = new People("李四",20,178,85);
        if(people1.compareTo(people2) > 0){
            System.out.println("张三年纪大");
        }else{
            System.out.println("李四年纪大");
        }
    }
}