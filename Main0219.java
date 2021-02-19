public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{8,4,6,5,2,1,7,3,9};
        int[] arr1 = new int[]{1,2,7,4,5,6,3,8};
//        Heap.heapify(arr1,arr1.length,2);
//        System.out.println(Arrays.toString(arr1));
//        Heap.heapify1(arr1,arr1.length,2);
//        System.out.println(Arrays.toString(arr1));
//        Heap.buildHeap(arr,arr.length);
//        System.out.println(Arrays.toString(arr));
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.add(5);
        queue.add(9);
        queue.add(3);
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
