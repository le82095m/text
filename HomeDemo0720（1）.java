import java.util.Scanner;
public class HomeDemo{

	public static void findNum(int arr[],int num){
		int i = 0;
		int j = 0;
		boolean judge = true;
		while(j < num){
			judge = true;
			for(i = 0;i < num;i++){
				if(arr[i] == arr[j] && i != j){
					judge = false;
					break;
				}
			} if(judge){
				System.out.println(arr[j]);
				break;
			  }
			j++;
		}
	}

	public static void main(String[] args) {
		int arr[10] = {0};
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i = 0;i < num;i++){
			arr[i] = sc.nextInt();
		}
		// int num = 5;
		findNum(arr,num);
	}
}