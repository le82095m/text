#ifndef _WINMINE_H_
#define _WINMINE_H_

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define ROW 12
#define COL 12
#define RAY 20
#define BLANK 100-RAY

void Menu();
void Game();
void IntiBoard(char arr[][COL], int row, int col,char symbol);
void ShowBoard(char arr[][COL], int row, int col);
void JudgeNum(char board[][COL], char mine[][COL], int x, int y);
void SetMine(char arr[][COL], int row, int col);



#endif 