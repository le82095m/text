//打印整数二进制的奇数位和偶数位
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
void print(int x) {
	int i;
	for (i = 31; i >= 0; i = i - 2) {
		printf("%d", (x >> i) & 1);
	}
	printf("\n");
	for (i = 30; i >= 0; i = i - 2) {
		printf("%d", (x >> i) & 1);
	}
}
int main() {
	int x;
	printf("请输入要判断的整数:\n");
	scanf("%d", &x);
	print(x);
}