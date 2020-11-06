package imp;

 public class LinkedList implements Deque{
    private static class Node{
        private Integer v;
        Node previous;
        Node next;
        Node(Integer e){
            v = e;
        }
        @Override
        public String toString() {
            return v + " ";
        }
    }
    private Node head;
    private Node tail;
    private int size;
    @Override
    public boolean offerFirst(Integer e) {
        Node node = new Node(e);
        if (size == 0) {
            head = node;
            tail = node;
        }else {
            head.previous = node;
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekFirst() {
        if(head == null){
            return null;
        }
        return head.v;
    }

    @Override
    public Integer pollFirst() {
        if(size == 0){
            return null;
        }
        int num = head.v;
        head = head.next;
        if(head != null){
            head.previous = null;
        }else{
            tail = null;
        }
        size--;
        return num;
    }

    @Override
    public boolean offerLast(Integer e) {
        Node node = new Node(e);
        if(size == 0){
            head = node;
        }else{
            node.previous = tail;
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    @Override
    public Integer peekLast() {
        if(tail == null){
            return null;
        }
        return tail.v;
    }

    @Override
    public Integer pollLast() {
        if(size == 0){
            return null;
        }
        int num = tail.v;
        tail = tail.previous;
        if(tail != null){
            tail.next = null;
        }else{
            head = null;
        }
        size--;
        return num;
    }
 }
