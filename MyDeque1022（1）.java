class MyCircularDeque {
    public int[] arr;
    public int size;
    public int front;
    public int last;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        size = k;
        front = 0;
        last = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(last < size-1){
            if (last >= 0) System.arraycopy(arr, 0, arr, 1, last);
            arr[0] = value;
            last++;
            return true;
        }else{
            return false;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(last < size-1) {
            arr[last] = value;
            last++;
            return true;
        }else{
            return false;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (last > 0) {
            System.arraycopy(arr, 1, arr, 0, last - 1);
            last--;
            return true;
        }else{
            return false;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (last > 0){
            last--;
            return true;
        }else{
            return false;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(last > 0){
            return arr[front];
        }else{
            return -1;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(last > 0){
            return arr[last];
        }else{
            return -1;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return last == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return last == size - 1;
    }
}