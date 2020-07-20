import java.util.Scanner;
public class HomeDemo{
	public static int fib(int n){
		if(n > 1){
			return fib(n-1)+fib(n-2);
		} else {
			return n;
		}
	}



	public static void main(String[] args) {
		int n = 3;
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