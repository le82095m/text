public class MyHashTable {

    private final Node[] array = new Node[11];
    private int size = 0;

    public boolean insert(Integer val){
        int hashValue = val.hashCode();
        int index = hashValue % array.length;
        Node node = new Node(val);
        Node cur = array[index];
        while (cur != null) {
            if (cur.val.equals(val)) {
                return false;
            } else {
                cur = cur.next;
            }
        }
        node.next = array[index];
        array[index] = node;
        return true;
    }


    public boolean contains(Integer val){
        int hashValue = val.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];
        while(cur != null){
            if(cur.val.equals(val)){
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }


    public boolean remove(Integer val){
        int hashValue = val.hashCode();
        int index = hashValue % array.length;
        if(array[index] != null){
            if(array[index].equals(val)){
                array[index] = array[index].next;
                return true;
            }
        }else{
            return false;
        }
        Node cur = array[index].next;
        Node pre = array[index];
        while (cur != null){
            if(cur.val.equals(val)){
                pre.next = cur.next;
                return true;
            }else{
                pre = cur;
                cur = cur.next;
                pre = pre.next;
            }
        }
        return false;
    }
}