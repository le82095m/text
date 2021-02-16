import java.util.Arrays;

class OrderSheet {
    int[] arr;
    int arrSize;

    public OrderSheet(int num) {
        this.arr = new int[num];
    }
        // 打印顺序表
        public void display() {
            for (int i = 0; i <this.arrSize ; i++) {
                System.out.print(this.arr[i]+" ");
            }
        }
        // 在 pos 位置新增元素
        public void add(int pos, int data) {
            if(pos < 0||pos > this.arrSize){
                System.out.println("error!");
                return ;
            }
            if(pos > this.arr.length-1){
                this.arr = Arrays.copyOf(this.arr,2*this.arr.length);
            }
            for (int i = this.arrSize-1; i >= pos ; i--) {
                this.arr[i+1] = this.arr[i];
            }
            this.arr[pos] = data;
            this.arrSize++;
        }
        // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i <this.arrSize ; i++) {
                if(this.arr[i] == toFind){
                    return true;
                }
            }
            return false;
        }
        // 查找某个元素对应的位置
        public int search(int toFind) {
            for (int i = 0; i <this.arrSize ; i++) {
                if(this.arr[i] == toFind){
                    return i;
                }
            }
            return -1;
        }
        // 获取 pos 位置的元素
        public int getPos(int pos) {
            if(pos < 0 || pos > this.arrSize) {
                System.out.println("error!");
            }
            return this.arr[pos];
        }
        // 给 pos 位置的元素设为 value
        public void setPos(int pos, int value) {
            if(pos < 0 || pos > this.arrSize) {
                System.out.println("error!");
            }
            this.arr[pos] = value;
        }
        //删除第一次出现的关键字key
        public void remove(int toRemove) {
            int i = this.search(toRemove);
            if (i != -1) {
                for (; i < this.arrSize; i++) {
                    this.arr[i] = this.arr[i + 1];
                }
                this.arrSize--;
            } else{
                System.out.println("没有该数字");
            }
        }
        // 获取顺序表长度
        public int size() {
            return this.arrSize;
        }
        // 清空顺序表
        public void clear() {
            this.arr = null;
            this.arrSize = 0;
        }
}

public class TestDemo{
    public static void main(String[] args) {
        OrderSheet os = new OrderSheet(10);
        os.add(0,15);
        os.add(1,4);
        os.add(2,8);
        os.add(3,16);
        os.add(4,24);
        os.display();
        System.out.println(" ");
        os.remove(4);
        os.remove(16);
        os.remove(15);
        os.remove(20);
        os.display();
    }
}
