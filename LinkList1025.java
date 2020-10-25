class MyLinkedList {

    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return " " +
                     + val +
                    ' ';
        }
    }
    Node head;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null){
            return -1;
        }
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (count == index) {
                return cur.val;
            }
            count++;
            cur = cur.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(size == 0){
            head.val = val;
        }else{
            Node node = new Node(val);
            node.next = head;
            head = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(size == 0){
            head.val = val;
        }else{
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
        size++;
    }
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            size++;
            return;
        }
        Node node = new Node(val);
        Node cur = findNode(index);
        assert cur != null;
        Node curNext = cur.next;
        cur.next = node;
        node.next = curNext;
        size++;
    }

    private Node findNode(int index) {
        Node cur = head;
        int count = 1;
        while (cur != null){
            if(count >= index){
                return cur;
            }
            cur = cur.next;
            count++;
        }
        return null;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0){
            head = head.next;
            size--;
            return;
        }
        Node cur = findNode(index);
        if(cur == null || cur.next == null){
            return;
        }
        cur.next = cur.next.next;
        size--;
    }

    public void print(){
        Node cur = head;
        while (cur != null){
            System.out.print(cur);
            cur = cur.next;
        }
    }
}