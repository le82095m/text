#include"test.h"


int power(int _num1, int _num2) {
	if (_num2 == 1)
		return _num1;
	else
		return _num1*power(_num1, (_num2-1));
}