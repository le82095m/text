class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
    }
}

class LinkList {
    public Node head;

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node cur = this.head;
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        if (index == 0) {
            System.out.println("error");
            return false;
        }
        Node node = new Node(data);
        Node cur = searchPrec(index);
        Node sub = cur.next;
        cur.next = node;
        node.next = sub;
        return true;
    }

    //寻找下标为index的结点
    public Node searchPrec(int index) {
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
//        if (head.data == key) {
//            Node temp = head;
//            head = head.next;
//            temp.next = null;
//        } else {
//            Node cur = searchPrev(key);
//            cur.next = cur.next.next;
//        }
        Node cur = this.head;
        if (head.data == key) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return;
        }
        while(cur.next != null){
            if(cur.next.data == key){
                cur.next = cur.next.next;
                return;
            } else{
                cur = cur.next;
            }
        }
        System.out.println("未找到关键字为"+key+"的结点");
    }

    //寻找data为key的结点
    public Node searchPrev(int key) {
        if (head == null) {
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prve = head;
        while (prve != null && prve.data == key) {
            head = head.next;
            prve = head;
        }
        //删除符合条件的头结点
        if (head == null) {
            return;
        }
        //判断是否为空链表
        Node cur = head.next;
        while (cur != null) {
            //遍历一遍链表，找到符合条件的结点
            if (cur.data == key) {
                prve.next = cur.next;
                //将该结点的前驱修改，使指向后继
            } else {
                prve = prve.next;
                //当cur结点不满足条件时，前驱向后移一位保证prve始终是cur的前驱
            }
            cur = cur.next;
            //每次执行完判断，cur都要往后移一位，保证下次正常判断
        }
        //删除头结点之后符合条件的结点
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int lang = 0;
        while (cur.next != null) {
            cur = cur.next;
            lang++;
        }
        return lang;
    }

    //打印链表
    public void display() {
        Node cur = this.head;
        if (head == null) {
            System.out.println("空链表");
        }
        do {
            assert cur != null;
            System.out.println(cur.data);
            cur = cur.next;
        } while (cur != null);
    }

    public void clear() {
        this.head = null;
    }

    //翻转整个链表
    public Node Solution() {
        Node cur = this.head;
        Node curNext =cur.next ;
        Node prve = this.head;
        while (curNext != null) {
            cur = curNext;
            curNext = cur.next;
            cur.next = prve;
            prve = cur;
        }
        this.head.next = null;
        this.head = cur;
        return head;
    }

    //查找链表的中间结点
    public Node midNode(){
        if (head == null) {
            return null;
        }
        Node cur = this.head;
        Node mid = this.head;
        //创建一个对象mid
        int i = 0;
        while (cur.next != null){
            if(i%2 == 0){
                mid = mid.next;
                //遍历一遍链表，当cur每项后移动两个结点时，mid向后移动一个结点
            }
            cur = cur.next;
            i++;
        }
        return mid;
    }

    //查找链表中到数第n个结点
    public Node numNode(int k){
        if (head == null) {
            return null;
        }
        if(k < 1){
            return null;
        }
        Node cur = this.head;
        Node node = this.head;
        while (cur.next != null){
            if(k <= 1){
                node = node.next;
            }
            cur = cur.next;
            k--;
        }
        if(k >1){
            return null;
        }
        return node;
    }

    //打印单个结点
    public void show(Node node){
        if(node == null){
            System.out.println("空结点");
            return;
        } else{
            System.out.println(node.data);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addLast(8);
        list.addLast(5);
        list.addLast(12);
        list.addLast(19);
        list.addLast(25);
        list.show(list.numNode(0));
    }
}