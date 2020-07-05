//Ä£ÄâÊµÏÖstrncat

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* my_strncat(char* dst, const char* str, int num) {	int i = 0;	int j = 0;	while (1) 	{		if (*(dst + i) != '\0')			i++;		else		{			while (j<num) 			{				(*(dst + i + j)) = (*(str + j));				j++;			}			*(dst + i + j ) = '\0';			break;		}	}	return dst;}int main() {
	char a[10] = "abcde";	char *b = "fghi";	puts(my_strncat(a, b, 4));}