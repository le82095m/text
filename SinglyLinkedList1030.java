package MyLinkedList;

public class SinglyLinkedList implements List{
    protected Node head;
    private int size;

    @Override
    public void add(Integer e) {
        Node node = new Node(e);
        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }

    @Override
    public boolean add(int index, Integer element) {
        if(index < 0 || index > size){
            return false;
        }
        if(index == 0){
            addFirst(element);
            return true;
        }
        int count = 0;
        Node node = new Node(element);
        Node cur = head;
        while (count < index-1){
            cur = cur.next;
            count++;
        }
        Node t = cur.next;
        cur.next = node;
        node.next = t;
        size++;
        return true;
    }

    @Override
    public void addFirst(Integer e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public void addLast(Integer e) {
        add(e);
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public boolean contains(Object o) {
        Node cur = head;
        while (cur != null){
            if(o.equals(cur.element)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public Integer getFirst() {
        if(head == null) {
            return null;
        }else{
            return head.element;
        }
    }

    @Override
    public Integer getLast() {
        if(head == null){
            return null;
        }else{
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            return cur.element;
        }
    }

    @Override
    public int indexOf(Object o) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if(o.equals(cur.element)){
                return count;
            }
            cur = cur.next;
            count++;
        }
            return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int out = -1;
        int count = 0;
        Node cur = head;
        while (cur != null){
            if(o.equals(cur.element)){
                out = count;
            }
            cur = cur.next;
            count++;
        }
        return out;
    }

    @Override
    public Integer remove() {
        if(head == null){
            return null;
        }
        int out = head.element;
        head = head.next;
        size--;
        return out;
    }

    @Override
    public Integer remove(int index) {
        if(index < 0 || index > size-1){
            return null;
        }
        if(index == 0){
            return remove();
        }
        Node cur = head;
        Node pre = null;
        int count = 0;
        while(count < index){
            pre = cur;
            cur = cur.next;
            count++;
        }
        int out = cur.next.element;
        pre.next = cur.next;
        size--;
        return out;
    }

    @Override
    public boolean remove(Object o) {
        Node cur = head;
        Node pre = null;
        int count = 0;
        while(cur != null){
            if(o.equals(cur.element)){
                if(pre == null){
                    remove();
                }else {
                    pre.next = cur.next;
                }
                return true;
            }
                pre = cur;
                cur = cur.next;
        }
        return false;
    }

    @Override
    public Integer removeFirst() {
        return remove();
    }

    @Override
    public Integer set(int index, Integer element) {
        int count = 0;
        Node cur = head;
        while (cur != null){
            if(count == index){
                int out = cur.element;
                cur.element = element;
                return out;
            }
            count++;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Integer removeLast() {
        Node pre = null;
        Node cur = head;
        while (cur.next != null){
            pre = cur;
            cur = cur.next;
        }if(pre == null){
            return null;
        }
        pre.next = null;
        return cur.element;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(this);
    }

    public void print(){
        Node cur = head;
        System.out.print("[");
        while (cur != null){
            System.out.print(cur);
            cur = cur.next;
        }
        System.out.println("]");
    }
}
