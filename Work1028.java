package WorkDemo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int count = 0;
        while (count < queue.size()-1){
            int num = queue.remove();
            queue.add(num);
            count++;
        }
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        int count = 0;
        int num = 0;
        while (count < queue.size()){
            num = queue.remove();
            queue.add(num);
            count++;
        }
        return num;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}



class MyQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackOut.isEmpty() && stackIn.isEmpty()){
            return -1;
        }
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
            return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackOut.isEmpty() && stackIn.isEmpty()){
            return -1;
        }
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}



class MinStack {

    Deque<Integer> stack;
    Deque<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        stackMin = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty() || x<stackMin.peek()){
            stackMin.push(x);
        }else{
            stackMin.push(stackMin.peek());
        }
    }
    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.element();
    }

    public int getMin() {
        return stackMin.element();
    }
}




class MyCircularQueue {
    private int[] arr;
    int size;
    private int start;
    private int end;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
        size = 0;
        start = 0;
        end = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size < arr.length) {
            arr[end] = value;
            size++;
            if(end == arr.length-1) {
                end = 0;
            }else{
                end++;
            }
            return true;
        }else{
            return false;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            size--;
            if (start == arr.length - 1) {
                start = 0;
            } else {
                start++;
            }
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[start];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()) {
            if (end == 0) {
                return arr[arr.length - 1];
            } else {
                return arr[end - 1];
            }
        }else{
            return -1;
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}