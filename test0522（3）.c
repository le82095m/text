//喝汽水，1瓶汽水1元，2个空瓶可以换一瓶汽水，给20元，可以多少汽水
//编程实现

//思路及算法
//定义一个结构体数组soda[]，元素soad[n]为一个瓶子和一个瓶盖
//当将两个瓶盖清零时，则增加一个数组元素soad[n+1]
//当数组内元素瓶盖数小于2时，统计瓶子数

#include<stdio.h>
#include<math.h>
void rhombus() {//构造一个菱形打印函数
	int i = 0, j = 0;
	int n = 0;
	int befor = 0, after = 0;
	for (j = 1; j <= 7; j++) {//打印菱形上半段
		befor = 7 - j;
		while (befor > 0) {//控制每行空格数
			printf(" ");
			befor--;
		}
		n = j * 2 - 1;
		while (n > 0) {//控制每行*数
			printf("*");
			n--;
		}
		printf("\n");//控制行数
	}
	for (j = 6; j > 0; j--) {//打印菱形下半段
		befor = 7 - j;
		while (befor > 0) {//控制每行的空格数
			printf(" ");
			befor--;
		}
		n = j * 2 - 1;
		while (n > 0) {//控制每行的*数
			printf("*");
			n--;
		}
		printf("\n");//控制行数
	}
}
int main() {
	rhombus();
}