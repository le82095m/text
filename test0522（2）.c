//喝汽水，1瓶汽水1元，2个空瓶可以换一瓶汽水，给20元，可以多少汽水
//编程实现

//思路及算法
//定义一个结构体数组soda[]，元素soad[n]为一个瓶子和一个瓶盖
//当将两个瓶盖清零时，则增加一个数组元素soad[n+1]
//当数组内元素瓶盖数小于2时，统计瓶子数

#include<stdio.h>

int soda(int n) {
	int sum = n;
	if (n > 1) {
		if (n % 2 == 0)
			sum += 1;
		while (n > 1) {
			if (n % 2 == 0) {
				n = n / 2;
			}
			else {
				n = n / 2 + 1;
			}
			if (n % 2 == 0) {
				sum = sum + n;
			}
			else {
				sum = sum + n - 1;
			}
		}
		return sum;
	}
	else {
		return 1;
	}
}

int main() {
	int num = 100;
	printf("%d元一共可以换%d瓶汽水", num, soda(num));
}

