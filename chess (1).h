#ifndef _CHESS_H
#define _CHESS_H

//Èý×ÓÆå
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
#include<time.h>

#define ROW 3
#define COL 3
#define BLACKBOARD 'X'
#define WHITEBOARD 'O'
int Game();
void Menu();
void InitBoard(char arr[][COL],int row,int col);
void ShowBoard(char arr[][COL],int row,int col);
void WhiteJudge(char arr[][COL],int row,int col);
void BlackJudge(char arr[][COL],int row,int col);
char WinJudge(char arr[][COL],int row,int col);


#endif