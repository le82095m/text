package MyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.addFirst(6);
        list.print();//6 1 2 3 4 5
        list.remove();
        list.remove(2);
        list.print();//1 2 4 5
        System.out.println(list.getFirst());//1
        System.out.println(list.getLast());//5
        System.out.println(list.size());//4
        System.out.println(list.contains(5));//true
        System.out.println(list.contains(10));//false
        list.print();//
    }
}
