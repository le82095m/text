package MyLinkedList;

public interface List extends Iterable {
    void add(Integer e);
    //将指定的元素追加到此列表的末尾
    boolean add(int index, Integer element);
    //在此列表中的指定位置插入指定的元素
    void addFirst(Integer e);
    //在该列表开头插入指定的元素
    void addLast(Integer e);
    //将指定的元素追加到此列表的末尾
    void clear();
    //从列表中删除所有元素
    boolean contains(Object o);
    //如果此列表包含指定的元素，则返回 true
    Integer getFirst();
    //返回此列表中的第一个元素
    Integer getLast();
    //返回此列表中的最后一个元素
    int indexOf(Object o);
    //返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1
    int lastIndexOf(Object o);
    //返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1
    Integer remove();
    //检索并删除此列表的头（第一个元素）
    Integer remove(int index);
    //删除该列表中指定位置的元素
    boolean remove(Object o);
    //从列表中删除指定元素的第一个出现（如果存在）
    Integer removeFirst();
    //从此列表中删除并返回第一个元素
    Integer set(int index, Integer element);
    //用指定的元素替换此列表中指定位置的元素
    int size();
    //返回此列表中的元素数
    Integer removeLast();
    //从此列表中删除并返回最后一个元素
}
