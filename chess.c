#include"chess.h"


void Menu() {
	printf("********欢迎来到三子棋游戏室********\n");
	printf("************************************\n");
	printf("***********1、开始游戏**************\n");
	printf("***********2、退出游戏**************\n");
	printf("************************************\n");
}
void InitBoard(char arr[ROW][COL], int row, int col) {
	int i, j;
	for (i = 0; i < row; i++)
		for (j = 0; j < col; j++) {
			arr[i][j] = ' ';
		}
}
void ShowBoard(char arr[ROW][COL], int row, int col) {
	int i;
	for (i = 0; i < row; i++) {
		printf("--------------------\n");
		printf(" %d | %c | %c | %c |\n", i+1, arr[0][i], arr[1][i], arr[2][i]);
	}
}
void WhiteJudge(char arr[ROW][COL], int x, int y) {
	if (arr[x][y] == ' ')
		arr[x][y] = BLACKBOARD;
}
void BlackJudge(char arr[ROW][COL]) {
	while (1) {
		int h = rand() % 3;
		int l = rand() % 3;
		if (arr[h][l] == ' ') {
			arr[h][l] = BLACKBOARD;
			break;
		}
		else
			continue;
	}
}
char WinJudge(char arr[ROW][COL], int row, int col) {
	int i, j;
	for (i = 0; i < row; i++)
		for (j = 0; j < col; j++) {
			if (arr[i][j] == ' ')
				return 'N';
		}
	for (i = 0; i < 3; i++) {
		if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2])
			return arr[i][0];
	}
	for (i = 0; i < 3; i++) {
		if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i])
			return arr[0][i];
	}
	if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])
		return arr[0][0];
	if (arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2])
		return arr[2][0];
	return 'D';
}
void Game() {
	int row = 3, col = 3;
	int choice1 = 0, choice2 = 0;
	char board[ROW][COL] = {0};
	InitBoard(board[ROW][COL], row, col);
	while (1) {
		ShowBoard(board[ROW][COL], row, col);
		printf("请选择你要下棋子的坐标");
		scanf("%d%d", &choice1, &choice2);
		WhiteJudge(board[ROW][COL], choice1, choice2);
		if (WinJudge(board[ROW][COL], row, col) == 'N')
			;
		else {
			printf("%c", WinJudge(board[ROW][COL], row, col));
			break;
		}
		srand((unsigned long)time(NULL));
		BlackJudge(board[ROW][COL]);
		WinJudge(board[ROW][COL], row, col);
	}
}