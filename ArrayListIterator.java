package List;

public class ArrayListIterator implements Iterator {
    //对一个顺序表迭代，重要在于控制下标
    private MyArrayList arrayList;
    private int index;

    public ArrayListIterator(MyArrayList arrayList) {
        this.arrayList = arrayList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < arrayList.size();
    }

    @Override
    public Object next() {
        return arrayList.get(index++);
    }

    @Override
    public void remove() {
        arrayList.clean();
    }
}
