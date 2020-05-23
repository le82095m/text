//调整数组使奇数全部都位于偶数前面。

//题目：
//输入一个整数数组，实现一个函数，
//来调整该数组中数字的顺序使得数组中所有的奇数位于数组的前半部分，
//所有偶数位于数组的后半部分。

#include<stdio.h>

void fun(int *arr1,int n,int *arr2) {
	int i = 0,j = 0;
	int sub = 0;
	for (i = 0; i < n/2; i++) {
		arr2[i] = arr1[sub*2];
		sub++;
	}
	sub = 0;
	for (j = n / 2; j < n; j++) {
		arr2[j] = arr1[sub*2+1];
		sub++;
	}
}

int main() {
	int i = 0;
	int arr1[10] = {1,2,3,4,5,6,7,8,9,10};
	int arr2[15] = { NULL };
	int n = sizeof(arr2) / sizeof(arr2[0]);
	fun(arr1, n, arr2);
	for (i = 0; i < n; i++) {
		printf("%x ", arr2[i]);
	}
}