package imp;

import java.util.NoSuchElementException;
//仿写(java.util.impl.Queue)的 Queue 接口

public interface Queue {
    //通过返回特殊值来通知错误的一组方法
    //插入(true 成功，false 失败)
    boolean offer(Integer e);
    //查看，返回队首元素，但不删除(返回null为空列表)
    Integer peek();
    //删除，返回并删除并删除首元素(返回null为空列表)
    Integer poll();

    //通过抛出异常来通知错误的一组方法
    //插入(永远返回true)
    default boolean add(Integer e){
        if(!offer(e)){
            throw new IllegalStateException();
        }
        return offer(e);
    }
    //查看，返回队首元素，但不删除
    default Integer element(){
        if(peek() == null){
            throw new NoSuchElementException();
        }
        return peek();
    }
    //删除，返回并删除并删除首元素
    default Integer remove(){
        if(poll() == null){
            throw new NoSuchElementException();
        }
        return poll();
    }
}
