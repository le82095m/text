#include"test.h"


int main() {
	int num1;
	int num2;
	printf("请输入一个整数和它的次方数:\n");
	scanf("%d%d", &num1,&num2);
	printf("%d\n",power(num1,num2));
	system("pause");
}