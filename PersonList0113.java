import java.util.ArrayList;
import java.util.List;

class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(o instanceof Person){
            return true;
        }
        if(this == o){
            return true;
        }
        Person obj = (Person) o;
        return obj.age == this.age || this.name.equals(((Person) o).name) ;
    }

}


public class PersonList {
    public static void main(String[] args) {
        Person p1 = new Person("张三",18);
        Person p2 = new Person("李四",20);
        Person p3 = new Person("王五",18);
        Person p4 = new Person("梅六",20);
        List <Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println(list.contains(p1));
        System.out.println(list.contains(p4));
        System.out.println(list.indexOf(p2));
        System.out.println(list.indexOf(p4));
}
