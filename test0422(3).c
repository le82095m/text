#include"test.h"

int factorial(int num) {
	if (num == 1) {
		return num;
	}
	else
		return num*factorial(num-1);
}