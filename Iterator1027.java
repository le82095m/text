package List;
//仿写真实的(java.util.Iterator)接口

public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
