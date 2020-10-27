package List;
//仿写真实的(java.util.List)List接口

public interface List<E> extends Iterator{
    boolean add(E e);
    void addIndex(int index,E e);
    void clean();
    boolean contains();
    boolean equals(Object e);
    E get(int index);
    int indexOf(Object o);
    boolean isEmpty();
    E remove(int index);
    boolean remove(Object o);
    E set(int index, E e);
    int size();

}