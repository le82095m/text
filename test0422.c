#include"test.h"

int Mystrlen(char* str) {
	if (*str == '\0')
		return 0;
	else
		return 1 + Mystrlen(str+1);
}