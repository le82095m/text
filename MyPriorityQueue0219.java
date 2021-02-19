public class MyPriorityQueue {
    private int[] arr;
    private int size;

    public MyPriorityQueue() {
        this.arr = new int[100];
        this.size = 0;
    }

    public int element(){
        if(size == 0){
            throw new RuntimeException("空队列");
        }else{
            return arr[0];
        }
    }

    public int remove(){
        if(size == 0){
            throw new RuntimeException("空队列");
        }else{
            Heap.exchange(arr,0,size-1);
            int out = arr[size-1];
            size--;
            heapify(0);
            return out;
        }
    }

    public void add(int v){
        if(size >= arr.length){
            throw new RuntimeException("队列已满");
        }
        int indexV = size;
        arr[size] = v;
        size++;
        adjustUp(size-1);
    }

    private void heapify(int index){
        while (true) {
            int left = index * 2 + 1;
            if(left > size || size <= 1){
                return;
            }
            if(left == size-1){
                if(arr[left] < arr[index]){
                    Heap.exchange(arr,left,index);
                    index = left;
                }
            }else{
                if(arr[left] < arr[left+1] && arr[left] < arr[index]){
                    Heap.exchange(arr,left,index);
                    index = left;
                }
                if(arr[left+1] < arr[left] && arr[left+1] < arr[index]){
                    Heap.exchange(arr,left+1,index);
                    index = left+1;
                }
            }
        }
    }
    private void adjustUp(int index){
        while (true) {
            int parent = (index-1)/2;
            if(parent < 0){
                return;
            }
            if (arr[index] < arr[parent]){
                Heap.exchange(arr,index,parent);
                index = parent;
            }else{
                return;
            }
        }
    }
}