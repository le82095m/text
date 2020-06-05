#include"cal.h"

int MyAdd(int a, int b) {
	return a + b;
}
int MySub(int a, int b) {
	return a - b;
}
int MyMul(int a, int b) {
	return a * b;
}
int MyDiv(int a, int b) {
	if (b == 0) {
		printf("warn not zero!");
		return -1;
	}
	else
		return a / b;
}