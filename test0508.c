//写一个函数打印arr数组的内容，不使用数组下标，使用指针。
//arr是一个整形一维数组。
#include<stdio.h>
#include<stdlib.h>

int main() {
	int arr[5] = { 1,2,3,4,5 };
	int *p = arr;
	int i;
	for (i = 0; i < 5; i++) {
		printf("%2d", *p + i);
	}
}