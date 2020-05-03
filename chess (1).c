#include"chess.h"


void Menu() {
	printf("********欢迎来到三子棋游戏室********\n");
	printf("************************************\n");
	printf("***********1、开始游戏**************\n");
	printf("***********2、退出游戏**************\n");
	printf("************************************\n");
}
void InitBoard(char arr[][COL], int row, int col) {
	int i, j;
	for (i = 0; i < row; i++)
		for (j = 0; j < col; j++) {
			arr[i][j] = ' ';
		}
}
void ShowBoard(char arr[][COL], int row, int col) {
	int i;
	printf("   | 1 | 2 | 3 |\n");
	for (i = 0; i < row; i++) {
		printf("----------------\n");
		printf(" %d | %c | %c | %c |\n", i+1, arr[0][i], arr[1][i], arr[2][i]);
	}
}
void WhiteJudge(char arr[][COL], int row, int col) {
	printf("请选择你要下棋子的坐标");
	int x = 0, y = 0;
reselect:
	scanf("%d%d", &x, &y);
	if (arr[x-1][y-1] == ' ')
		arr[x-1][y-1] = WHITEBOARD;
	else {
		printf("你选择的格子已有棋子,请重选:");
		goto reselect;
	}
}
void BlackJudge(char arr[][COL],int row, int col) {
	while (1) {
		int h = rand() % row;
		int l = rand() % col;
		if (arr[h][l] == ' ') {
			printf("电脑落子:%d %d\n", h + 1, l + 1);
			arr[h][l] = BLACKBOARD;
			break;
		}
	}
	printf("\n");
}
char WinJudge(char arr[][COL], int row, int col) {
	int i, j=0;
	for (i = 0; i < 3; i++) {
		if (arr[i][j] != ' '&&arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2])
			return arr[i][0];
	}
	for (i = 0; i < 3; i++) {
		if (arr[0][i] != ' '&&arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i])
			return arr[0][i];
	}
	if (arr[0][0] != ' '&&arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
		return arr[0][0];
	}
	if (arr[2][0] != ' '&&arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) {
		return arr[2][0];
	}
	for (i = 0; i < row; i++)
		for (j = 0; j < col; j++) {
			if (arr[i][j] == ' ')
				return 'N';
		}
	return 'D';
}
int Game() {
	char result;
	int row = 3, col = 3;
	char board[ROW][COL];
	InitBoard(board, ROW, COL);
	while (1) {
		ShowBoard(board, ROW, COL);
		WhiteJudge(board, ROW, COL);
		result = WinJudge(board, ROW, COL);
		switch (result) {
		case 'O':
			ShowBoard(board, ROW, COL);
			printf("恭喜你赢了!\n");
			return 0;
		case 'X':
			ShowBoard(board, ROW, COL);
			printf("很抱歉你输了!\n");
			return 0;
		case 'D':
			ShowBoard(board, ROW, COL);
			printf("你和电脑是平局!\n");
			return 0;
		default:
			break;
		}
		printf("\n");
		ShowBoard(board, ROW, COL);
		Sleep(500);
		srand((unsigned long)time(NULL));
		BlackJudge(board, ROW, COL);
		result = WinJudge(board, ROW, COL);
		switch (result) {
		case 'O':
			ShowBoard(board, ROW, COL);
			printf("恭喜你赢了!\n");
			return 0;
		case 'X':
			ShowBoard(board, ROW, COL);
			printf("很抱歉你输了!\n");
			return 0;
		case 'D':
			ShowBoard(board, ROW, COL);
			printf("你和电脑是平局!\n");
			return 0;
		default:
			break;
		}
	}
}