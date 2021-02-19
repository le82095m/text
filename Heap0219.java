public class Heap {
    public static void heapify(int[] arr,int size,int index){
        int left = 2*index+1;
        while(left < size) {
            if (left == size - 1) {
                if (arr[left] < arr[index]) {
                    exchange(arr, left, index);
                    index = left;
                }else{
                    return;
                }
            } else {
                if (arr[left] < arr[left + 1] && arr[left] < arr[index]) {
                    exchange(arr, left, index);
                    index = left;
                }else if (arr[left + 1] < arr[left] && arr[left + 1] < arr[index]) {
                    exchange(arr, left + 1, index);
                    index = left + 1;
                }else{
                    return;
                }
            }
            left = 2*index+1;
        }
    }

    public static void heapify1(int[] arr,int size,int index){
        while (true) {
            int left = index * 2 + 1;
            if(left > size-1){
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

    public static void exchange(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void buildHeap(int[] arr,int size){
        for(int i = ((size-1)-1)/2; i >= 0; i--){
            heapify(arr,size,i);
        }
    }
}
