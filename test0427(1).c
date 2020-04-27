#include"test.h"

int Bubble_sort(int arr[],int n) {
	int i,j;
	int temp=0;
	for (j = 0; j < n; j++) {
		for (i = 0; i < n-1; i++)
			if (arr[i] > arr[i + 1]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
	}
	return arr;
}