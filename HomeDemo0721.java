import java.util.Scanner;
public class HomeDemo{
	public static int fib(int n){
		if(n <= 1){
			return n;
		}
			int a = 0;
	    	int b = 1;
	    	int temp = 0;
	    for(int i = 2;i <= n;i++){
	    	temp = a + b;
	    	b = a;
	    	a = temp;
	    }
	    return temp;
	}





	public static int fib1(int n){
		if(n > 1){
			return fib(n-1)+fib(n-2);
		} else {
			return n;
		}
	}



	public static void main(String[] args) {
		int n = 10;
		System.out.println(fib(n));
	}

}


// 	public static void findNum(int arr[],int num){
// 		int i = 0;
// 		int j = 0;
// 		boolean judge = true;
// 		while(j < num){
// 			judge = true;
// 			for(i = 0;i < num;i++){
// 				if(arr[i] == arr[j] && i != j){
// 					judge = false;
// 					break;
// 				}
// 			} if(judge){
// 				System.out.println(arr[j]);
// 				break;
// 			  }
// 			j++;
// 		}
// 	}

// 	public static void main(String[] args) {
// 		int arr[5] = {1,2,3,2,1};
// 		 int num = 5;
// 		findNum(arr,num);
// 	}
// }