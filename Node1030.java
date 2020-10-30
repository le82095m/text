package MyLinkedList;

public class Node {
    Integer element;
    Node next;

    public Node(Integer val) {
        this.element = val;
    }

    @Override
    public String toString() {
        return " " + element + " ";
    }
}
