package MyLinkedList;

public class LinkedListIterator implements Iterator {
    private SinglyLinkedList list;
    private Node cur;

    public LinkedListIterator(SinglyLinkedList list) {
        this.list = list;
        this.cur = list.head;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }

    @Override
    public Integer next() {
        if(cur != null) {
            cur = cur.next;
            return cur.element;
        }else{
            return null;
        }
    }
}
