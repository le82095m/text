//Ä£ÄâÊµÏÖmemmove

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>

void * my_memmove(void * des, const void * str, size_t num){
	if (des>str && (char *)des < ((char *)str + num)){
		while (num > 0) {
			*((char*)des + num-1) = *((char*)str + num-1);
			num--;
		}
	}
	else {
		while (num > 0) {
			*(char*)des = *(char*)str;
			des=(char*)des+1;
			str=(char*)str+1;
			num--;
		}
	}
	return (char*)des;
}

int main() {
	char dst[50] = { 0 };
	char str[] = "memmove can be very useful......";
	my_memmove(str + 20, str + 15, 11);
	puts(str);
	return 0;
}