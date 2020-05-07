//交换两个变量（不创建临时变量）
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
void fun(int x, int y) {
	x ^= y;
	y ^= x;
	x ^= y;
	printf("%2d", x, y);
}
int main() {
	int x, y;
	printf("请输入要交换的两个整数:\n");
	scanf("%d%d", &x, &y);
	fun(x, y);
}