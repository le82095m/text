//模拟实现库函数strcpy
#include<stdio.h>
void my_strcpy(char *arr, char *str) {
	int i = 0;
	while (arr[i] != '\0') {
		str[i] = arr[i];
		i++;
	}
}
int main() {
	char arr[10] = { "ni hao" };
	char str[10] = { 0 };
	printf("befor:%s\n", str);
	my_strcpy(arr, str);
	printf("after:%s\n", str);
}