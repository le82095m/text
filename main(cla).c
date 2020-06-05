#include"cal.h"

void menu() {
	printf("************************\n");
	printf("**1.Add          2.Sub**\n");
	printf("**3.Mul          4.Div**\n");
	printf("**0.Exit         *******\n");
	printf("************************\n");
	printf("please enter the option:");
}

int main() {
	int select = 0;
	int(*p_fun[5])(int, int) = { NULL,MyAdd,MySub,MyMul,MyDiv };
	int input_a = 0;
	int input_b = 0;
	while (1) {
		menu();
		scanf("%d", &select);
		if (select < 0 || select>4) {
			printf("input is wrong!\n");
			continue;
		}
		if (select == 0) {
			break;
		}
		else {
			printf("please enter num of A\n");
			scanf("%d", &input_a);
			printf("please enter num of B\n");
			scanf("%d", &input_b);
			int result = p_fun[select](input_a, input_b);
			printf("%d\n", result);
		}
	}
}