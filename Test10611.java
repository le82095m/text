public class Test1 {
    public static void main(String[] args) {

    }
    public int duplicate(int[] numbers){
        //numbers {1,2,3,2,4,5}
        //res     {0,1,0,0,0,0}

        int[] res = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            res[number] = res[number]+1;
            int temp = res[number];
            if (temp == 2) {
                return number;
            }
        }
        return -1;
    }

    public void shiftDown(int[] arr,int size,int index){
        int left = index*2 + 1;
        while(left< size){
            int min = left;
            int right = index*2+2;
            if(right < size){
                if(arr[right] < arr[left]){
                    min = right;
                }
            }
            if(min > arr[index]){
                break;
            }
            int t = arr[index];
            arr[index] = arr[min];
            arr[min] = t;
            index = min;
            left = index*2 + 1;
        }
    }

    public void buildHeap(int[] arr,int size){
        for(int i = (size-1-1)/2; i >= 0 ;i--){
            shiftDown(arr,size,arr[i]);
        }
    }

    public void add(int e){

    }
    public void shiftUp(int[] arr,int index){
        while(index > 0){
            int par = (index-1)/2;
            if(arr[par] > arr[index]){
                break;
            }
            int t = arr[par];
            arr[par] = arr[index];
            arr[index] = t;

            index = par;
        }
    }

//    private List<Integer> topK(List<Integer> nums,int K){
//
//        for(int num : nums){
//            if(list.size() < K){
//                list.add()
//            }
//        }
//    }
}
