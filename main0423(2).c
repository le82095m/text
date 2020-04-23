#include"test.h"


int main() {
	int num;
	printf("请输入一个整数:\n");
	scanf("%d", &num);
	printf("%d\n", Fibonacci(num));
	system("pause");
}