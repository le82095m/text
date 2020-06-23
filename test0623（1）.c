//Ä£ÄâÊµÏÖstrstr

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>

char* my_strstr(char* str, char* dst) {
	int count = 0;
	char *p_str = str;
	char *p_dst = dst;
	while (*p_str) {
		int count = 0;
		if (*p_str == *p_dst) {
			while (*p_dst) {
				p_dst++;
				p_str++;
				count++;
				if (*p_dst != *p_str) {
					p_dst -= count;
					p_str -= count;
					break;
				}
				return p_str - count;
			}
		}
		p_str++;
	}
	return NULL;
}

int main() {
	char str[] = "This is a simple string";
	char * pch = NULL;
	pch = my_strstr(str, "simple");
	strncpy(pch, "sample", 6);
	puts(str);
	return 0;
}