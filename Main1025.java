public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1); //1
        myLinkedList.addAtTail(3); //1,3
        myLinkedList.addAtIndex(1,2); //1,2,3
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
        myLinkedList.print();
    }
}
