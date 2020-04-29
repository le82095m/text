#ifndef _CHESS_H
#define _CHESS_H

//Èý×ÓÆå
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
#define ROW 3
#define COL 3
#define BLACKBOARD 'X'
#define WHITEBOARD 'O'
void Game();
void Menu();
void InitBoard(char arr[ROW][COL],int row,int col);
void ShowBoard(char arr[ROW][COL],int row,int col);
void WhiteJudge(char arr[ROW][COL],int row,int col);
void BlackJudge(char arr[ROW][COL]);
void WinJudge(char arr[ROW][COL],int row,int col);


#endif