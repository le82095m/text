
class Demo{
    public static boolean judge(int num){
        double temp = (double)Math.abs(num);
        while (true){
            if(temp == 1.0){
                return true;
            }
            temp /= 2.0;
            if(temp < 1.0){
                return false;
            }
        }
    }
    public static void main5(String[] args) {
        //int num = 0;
        //System.out.println(judge(num));int a = 0;
        int c = 0;
        int a = 0;
        do{
            --c;
            a = a-1;
        }while(a > 0);
        System.out.println(a);
    }
}
class Node{
    public int val;
    public Node next;
}
class ListNode{
    public Node removeKthNode(Node head, int k) {
        if(head == null || head.next == null){
            return null;
        }
        Node cur = head.next;
        Node kCur = head;
        while (k > 1){
            cur = cur.next;
            k--;
        }
        while (cur != null){
            cur = cur.next;
            kCur = kCur.next;
        }
        kCur.next = kCur.next.next;
        return head;
    }

    public Node reverse(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node pre = null;
        Node curNext = null;
        while (cur != null){
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    public Node tailAdd(Node head,Node node){
        if(head == null){
            head = node;
        }
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        node.next = null;
        return head;
    }

    //  p         c
    //1,2,3,3,4,4,5
    public static Node remove(Node pHead){
        if(pHead == null){
            return null;
        }
        while (pHead.val == pHead.next.val){
            pHead = pHead.next;
        }
        Node cur = pHead.next;
        Node perv = pHead;
        while (cur.next != null){
            if(cur.val != cur.next.val){
                perv.next = cur;
                perv = cur;
            }
            while(cur.val == cur.next.val){
                cur = cur.next;
            }
            cur = cur.next;
        }
        perv.next = cur;
        return pHead;
    }
}
class Demo2{
    public static boolean nicoChester(int num){
        if(num == 0){
            return true;
        }
        double cube = Math.pow(num,3);
        int temp = (int)cube/num;
        int sum;
        if(temp % 2 == 1){
            sum = temp;
            for (int i = 1; i < num-i ; i++) {
                sum += temp-2*i + temp+2*i;
            }
        }else{
            sum = temp-1 + temp+1;
            for (int i = 1; i < num-i ; i++) {
                sum += temp-1-2*i + temp+1+2*i;
            }
        }
        return sum == (int)cube;
    }
    public static void main(String[] args) {
        int num = 10;
        for (int i = 0; i < num; i++) {
            System.out.println(nicoChester(i));
        }
    }
}
class Demo3{
    public static int defMax(int numA,int numB){
        int max = numA ^ numB;
        int temp;
        int carry = (numA & numB)<<1;
        while (carry != 0){
            temp = max;
            max = max ^ carry;
            carry = (temp & carry)<<1;
        }
        return max;
    }

    public static void main10(String[] args) {
        System.out.println(defMax(7, 5));
    }
}

//        示例 1 :
//        输入:array = [1,1,1], n = 2
//        输出: 2 因为： [1,1] 与 [1,1] 为两种不同的情况。
//        示例 2 :
//        输入:array = [3,2,1,4,1], n = 5
//        输出: 3 因为： [3,2] 与 [1,4], [4,1]
class Demo10{
    public static int subarray(int[] arr,int num){
        int sum = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum + arr[i] == num){
                count++;
                sum = 0;
            }else if(sum + arr[i] > num){
                sum = 0;
            }else{

            }
            sum += arr[i];
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,4,1};
        System.out.println(subarray(arr, 5));
    }
}
