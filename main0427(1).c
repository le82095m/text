#include"test.h"

int main() {
	int arr[50];
	printf("请输入要输入的整数个数:\n");
	int num;
	scanf("%d", &num);
	printf("请输入要排序的整数:\n");
	int i;
	for (i = 0; i < num; i++) {
		scanf("%d", &arr[i]);
	}
	Bubble_sort(arr,num);
	printf("由小到大排序后:\n");
	for (i = 0; i < num; i++) {
		printf("%d  ",arr[i]);
	}
	system("pause");
}