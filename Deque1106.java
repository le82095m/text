package imp;

import java.util.NoSuchElementException;

public interface Deque extends Queue {
    //通过返回特殊值来通知错误的一组方法
    boolean offerFirst(Integer e);
    Integer peekFirst();
    Integer pollFirst();
    boolean offerLast(Integer e);
    Integer peekLast();
    Integer pollLast();

    //通过抛出异常来通知错误的一组方法
    default boolean addFirst(Integer e){
        if(!offerFirst(e)){
            throw new IllegalStateException();
        }
        return offerFirst(e);
    }

    default boolean addLast(Integer e){
        if(!offerLast(e)){
            throw new IllegalStateException();
        }
        return offerLast(e);
    }

    default Integer getFirst(){
        if(peekFirst() == null){
            throw new NoSuchElementException();
        }
        return peekFirst();
    }

    default Integer getLast(){
        if(peekLast() == null){
            throw new NoSuchElementException();
        }
        return peekLast();
    }

    default Integer removeFirst(){
        if(pollFirst() == null){
            throw new NoSuchElementException();
        }
        return pollFirst();
    }

    default Integer removeLast(){
        if(pollLast() == null){
            throw new NoSuchElementException();
        }
        return pollLast();
    }

    //继承自 Queue 的方法
    default boolean offer(Integer e){
        return offerLast(e);
    }
    //查看，返回队首元素，但不删除(返回null为空列表)
    default Integer peek(){
        return  getFirst();
    }
    //删除，返回并删除并删除首元素(返回null为空列表)
    default Integer poll(){
        return pollFirst();
    }

    //为 stack 准备的方法
    default void push(Integer e){
        addFirst(e);
    }
    default Integer pop(){
        return removeFirst();
    }
}
