#include"test.h"

int print(int num) {
	if (num / 10 == 0) {
		return num;
	}
	else {
		printf("%3d", num % 10);
		return print(num / 10);
	}
}