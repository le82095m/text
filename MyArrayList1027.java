package List;
//仿写真实的(java.util.ArrayList)实现类
public class MyArrayList<E> implements List{
    private int[] arr;
    private int size;

    public MyArrayList(int[] arr, int size) {
        arr = new int[10];
        size = 0;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public void addIndex(int index, Object o) {
        if(index < 0){
            return;
        }
        if (size == arr.length) {
            int[] newArr =  new int[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        for (int i = size; i >= index; i--) {
            arr[i + 1] = arr[i];
            if (i == index) {
                arr[index] = (int)o;
                size++;
            }
        }
    }

    @Override
    public void clean() {

    }

    @Override
    public boolean contains() {
        for (int e : arr) {
            if(true)
                return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object set(int index, Object o) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
