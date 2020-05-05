#include"winmine.h"

void Menu() {
	printf("######欢迎来到扫雷游戏室#####\n");
	printf("#############################\n");
	printf("#######  1、开始游戏  #######\n");
	printf("#######  2、退出游戏  #######\n");
	printf("#############################\n");
	printf("请输入你的选择:");
}

void IntiBoard(char arr[][COL], int row, int col,char symbol) {
	int i, j;
	for(i=0;i<row;i++)
		for (j = 0; j < col; j++) {
			arr[i][j] = symbol;
		}
}

void ShowBoard(char arr[][COL], int row, int col) {
	int i;
	printf("---------------------------------------------\n");
	printf("|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |10 |\n");
	for (i = 1; i < row-2; i++) {
		printf("---------------------------------------------\n");
		printf("| %d | %c | %c | %c | %c | %c | %c | %c | %c | %c | %c |\n",i,arr[1][i], arr[2][i], arr[3][i], arr[4][i], arr[5][i], arr[6][i], arr[7][i], arr[8][i], arr[9][i], arr[10][i]);
	}		
	printf("---------------------------------------------\n");
	printf("|10 | %c | %c | %c | %c | %c | %c | %c | %c | %c | %c |\n",arr[1][10], arr[2][10], arr[3][10], arr[4][10], arr[5][10], arr[6][10], arr[7][10], arr[8][10], arr[9][10], arr[10][10]);
}

//void PlayerMove(char arr[][COL], int row, int col) {
//	char board[ROW][COL];
//	char mine[ROW][COL];
//	int x = 0, y = 0;
//	printf("请选择坐标:\n");
//next:
//	scanf("%d%d", &x, &y);
//	if (arr[x][y] == '*')
//		arr[x][y] = 'X';
//	else {
//		printf("此处已排过雷,请重选:");
//		goto next;
//	}
//}

void SetMine(char arr[][COL], int row, int col) {
	int ray=RAY;
	while(ray){
		int x = rand() % 10 + 1;
		int y = rand() % 10 + 1;
		if (arr[x][y] == '0') {
			arr[x][y] = '1';
			ray--;
		}
		else
			continue;
	}
}

void JudgeNum(char board[][COL],char mine[][COL], int x, int y) {
	int ray = 0;
	char c;
		if (board[x - 1][y - 1] == '1')
			ray++;
		if (board[x - 1][y] == '1')
			ray++;
		if (board[x - 1][y + 1] == '1')
			ray++;
		if (board[x][y - 1] == '1')
			ray++;
		if (board[x][y + 1] == '1')
			ray++;
		if (board[x + 1][y - 1] == '1')
			ray++;
		if (board[x + 1][y] == '1')
			ray++;
		if (board[x + 1][y + 1] == '1')
			ray++;
	c = ray + '0';
	mine[x][y] = c ;
}

void Game() {
	int sum = BLANK;
	char board[ROW][COL];
	char mine[ROW][COL];
	IntiBoard(board,ROW,COL,'0');
	IntiBoard(mine,ROW,COL,' ');
	srand((unsigned long)time(NULL));
	SetMine(board, ROW, COL);
	while (sum!=0) {
		ShowBoard(mine, ROW, COL);
		ShowBoard(board, ROW, COL);
		int x = 0, y = 0;
		printf("请选择坐标:\n");
	next:
		scanf("%d%d", &x, &y);
		if(x>0&&x<11&&y>0&&y<11){
			if (board[x][y] == '1') {
				printf("对不起你的选的坐标有雷,游戏结束!\n");
				break;
			}
			if (mine[x][y] == ' ') {
				board[x][y] = 'X';
				sum--;
			}
			else {
				printf("此处已排过雷,请重选:");
				goto next;
			}
			JudgeNum(board, mine, x, y);
		}
		else {
			printf("你输入的坐标有误,请重新输入!\n");
			goto next;
		}
	}
	if (sum == 0) {
		printf("恭喜你,赢了!\n");
	}
}