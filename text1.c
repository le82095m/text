//乘法口诀表
//*实现一个函数,打印乘法口诀表,口诀表的行数和列数自己指定
//如:输入9,输出9 * 9口诀表,输出12,输出12 * 12的乘法口诀表
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
void Multiply_table(int num) {
	int i,j;
	for (i = 1; i <= num; i++) {
		for (j = 1; j <= num; j++) {
			if(i>=j)
			printf("%d*%d=%d ", i, j, (i*j));
		}
		printf("\n");
	}
}
int main(){
	int input;
	printf("Plese enter the num:");
	scanf("%d", &input);
	Multiply_table(input);
	system("pause");
}
