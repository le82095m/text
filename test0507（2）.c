//打印整数二进制的奇数位和偶数位
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int fun1(int x) {
	int i = 0;
	while (x) {
		x = x & (x - 1);
		i++;
	}
	return i;
}
int main() {
	int x;
	printf("请输入要判断的整数:\n");
	scanf("%d", &x);
	printf("1的个数:%u\n", fun1(x));
}