import org.omg.CORBA.Object;

class MyArrayList<E>{
    private E[] arr;
    private int size = 0;

    public MyArrayList(int size) {
        if(size > 0){
            arr = (E[]) new Object[size];
        }else{
            arr = (E[]) new Object[10];
        }
    }

    // 打印顺序表
    public void display() {
        for (E e : arr) {
            System.out.print(e + " ");
        }

    }
    // 在 pos 位置新增元素
    public void add(int pos, E data) {
        if(pos < 0){
            return;
        }
        if (size == arr.length) {
            E[] newArr = (E[]) new Object[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        for (int i = size; i >= pos; i--) {
            arr[i + 1] = arr[i];
            if (i == pos) {
                arr[pos] = data;
                size++;
            }
        }
    }
    // 判定是否包含某个元素
    public boolean contains(Object toFind) {
        for (E e : arr) {
            if(e.equals(toFind))
            return true;
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(Object toFind) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(toFind)){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public E getPos(int pos) {
        if (pos < 0 || pos > size) {
            return null;
        }
        return arr[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, E value) {
        if (pos < 0 || pos > size) {
            return ;
        }
        arr[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(Object toRemove) {
        int i = 0;
        while (!arr[i].equals(toRemove)){
            i++;
            if(i > size){
                return;
            }
        }
        if (size - i >= 0) {
            System.arraycopy(arr, i + 1, arr, i, size - i);
            size--;
        }
    }
    // 获取顺序表长度
    public int size() {
        return size;
    }
    // 清空顺序表
    public void clear() {
        size = 0;
    }
}