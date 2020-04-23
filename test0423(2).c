#include"test.h"


int Fibonacci(int _num) {
	if (_num > 2)
		return Fibonacci(_num - 1) + Fibonacci(_num - 2);
	else
		return 1;
}