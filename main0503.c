#include"winmine.h"

int main() {
	int choice;
	int quit=0;
	Menu();
again:
		scanf("%d", &choice);
		switch (choice) {
		case(1):
			Game();
			printf("还要再来一局吗?1.继续2.退出\n");
			goto again;
		case(2):
			break;
		default:
			printf("你的输入有误,请重新输入!\n");
			goto again;
		}
}