//模拟实现库函数strlen
#include<stdio.h>
int my_strlen(char *str) {
	if (*str == '\0')
		return 0;
	else
		return 1 + my_strlen(str + 1);
}
int main() {
	char arr[10] = { "123456" };
	printf("%d", my_strlen(arr));
}