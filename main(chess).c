#include"chess.h"

int main() {
next:
	Menu();
	int choice;
	int m;
	printf("请输入您的选择:");
again:
	scanf("%d", &choice);
	switch (choice) {
	case(1):
		while (1) {
			Game();
			printf("是否要再来一局? 1、再来一局 2、返回菜单\n");
			scanf("%d", &m);
			if (m == 2)
				goto next;
			else if (m != 1) {
				printf("输入错误,三秒后自动退出!");
				Sleep(3000);
				break;
			}
		}
		break;
	case(2):
		break;
	default:
		printf("输入错误,请重新输入:\n");
		goto again;
	}
}