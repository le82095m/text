//编写程序数一下 1到 100 的所有整数中出现多少个数字9
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int fun(int ini, int cut) {
	int i;
	int sum = 0;
	for (i = ini; i <= cut; i++) {
		if (i / 100 == 0) {
			if ((i % 10) / 9 == 1) {
				sum++;
			}
			if ((i / 10) / 9 == 1) {
				sum++;
			}
		}
		else if (i / 1000 == 0) {
			if (((i % 100)%10) / 9 == 1) {
				sum++;
			}
			if ((i % 100) / 10 / 9 == 1) {
				sum++;
			}
			if ((i / 100) / 9 == 1) {
				sum++;
			}
		}
	}
	return sum;
}
int main() {
	int start, end;
	scanf("%d%d", &start, &end);
	int result = fun(start, end);
	printf("%d\n", result);
	system("pause");
}