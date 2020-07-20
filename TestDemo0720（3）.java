import java.util.Scanner;

public class TestDemo {
	public static void main(String[] args) {
		int num=1;
		int sum=0;
		while(num <= 5){
			int i = 1;
			int m = 1;
			while(i <= num){
				m *= i;
				i++;
			}
			sum += m;
			num++;
		}
		System.out.println(sum);
	}
	public static void main1(String[] args) {
		int i=1;
		int addSum=0;
		int eveSum=0;
		int sum=0;
		while(i<=100) {
			if(i%2==0) {
				eveSum+=i;
			}else {
				addSum+=i;
			}
			sum+=i;
			i++;
		}
		System.out.println("100以内奇数的和："+addSum);
		System.out.println("100以内偶数的和："+eveSum);
		System.out.println("100以内所有数的和："+sum);
	}
}