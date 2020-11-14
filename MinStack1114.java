package work;

import java.util.Deque;
import java.util.LinkedList;

//定义一个队列进行插入操作
//每输出一个，循环一次整个列表
//定义一个下标指向最小值
public class MinStack {
    Deque<Integer> queue = new LinkedList<>();
    int min = 2147483647;
    int minIndex = 0;
    public void push(Integer e){
        queue.add(e);
        if(e < min){
            minIndex = queue.size()-1;
            min = e;
        }
    }
    public Integer peek(){
        int count = 1;
        while(count < queue.size()){
            Integer num =  queue.remove();
            queue.add(num);
            count++;
        }
        Integer num =  queue.remove();
        queue.add(num);
        return queue.element();
    }
    public Integer pop(){
        int num = peek();
        queue.remove();
        return num;
    }
    public Integer minData(){
        return min;
    }

    @Override
    public String toString() {
        return queue+"";
    }
}
