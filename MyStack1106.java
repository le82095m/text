package imp;

public class MyStack {
    public int removeDuplicates(int A ,int B) {
        int C = 0;
        if(A%B == 0){
            return A;
        }else if(B%A == 0){
            return B;
        }else{
            for(C = 1 ; C < B * A ; C++){
                if((C%A == 0) && (C%B == 0)){
                    return C;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int A = 12;
        int B = 11;
        int C = 0;
        if(A%B == 0){
            System.out.println(A);
        }else if(B%A == 0){
            System.out.println(B);
        }else{
            for(C = 1 ; C <= B * A ; C++){
                if((C%A == 0) && (C%B == 0)){
                    System.out.println(C);
                }
            }
        }
//        Deque myStack = new LinkedList();
//        myStack.push(1);
//        System.out.print(myStack.peek()+" ");
//        myStack.push(2);
//        System.out.print(myStack.peek()+" ");
//        myStack.push(3);
//        System.out.print(myStack.peek()+" ");
//        myStack.push(4);
//        System.out.print(myStack.peek()+" ");
//        myStack.push(5);
//        System.out.println(myStack.peek()+" ");
//        myStack.pop();
//        System.out.println(myStack.peek());
    }
}
