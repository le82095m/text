//Ä£ÄâÊµÏÖatoi

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int if_num(char *arr) {
	if (arr[0]<'0' || arr[0]>'9') {
		if (arr[0] == '+')
			return 1;
		else if (arr[0] == '-')
			return 2;
		else
			return 0;
	}
	return 3;
}

int total_num(char *arr) {
	int i = 0;
	if (arr[0] == '0')
		return 0;
	while (1) {
		if (arr[i] >= '0'&&arr[i] <= '9')
			i++;
		else
			break;
	}
	return i;
}

int my_pow(int x, int y)
{
	int sum = 1;
	while (y-1) {
		sum *= x;
		y--;
	}
	return sum;
}
int my_atoi(char *arr)
{
	int result = 0;
	int i = 0;
	int temp;
	if (if_num(arr) == 0)
		return 0;
	if (if_num(arr) == 1)
	{
		int num = total_num(arr + 1);
		while (num)
		{
			temp = (arr[i+1]-48)*(my_pow(10, num));
			result += temp;
			num--;
			i++;
		}
		return result;
	}
	if (if_num(arr) == 2)
	{
		int num = total_num(arr + 1);
		while (num)
		{
			temp = (arr[i+1]-48)*(my_pow(10, num));
			result += temp;
			num--;
			i++;
		}
		return (result*(-1));
	}
	if (if_num(arr) == 3)
	{
		int num = total_num(arr);
		while (num)
		{
			temp = (arr[i]-48)*(my_pow(10, num));
			result += temp;
			num--;
			i++;
		}
		return result;
	}
}


int main() {
	char *p = "-1234";
	printf("%d\n", my_atoi(p));
}
