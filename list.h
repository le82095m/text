#pragma once
#ifndef _ADDRESS_LIST_H
#define _ADDRESS_LIST_H

//实现一个通讯录；

//通讯录可以用来存储1000个人的信息，每个人的信息包括：姓名、性别、年龄、电话、住址
//提供方法：

//添加联系人信息
//删除指定联系人信息
//查找指定联系人信息
//修改指定联系人信息
//显示所有联系人信息
//清空所有联系人
//以名字排序所有联系人

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


typedef struct addersee_list {
	char name[32];
	char gender[5];
	char age[4];
	char mobile[13];
	char home_add[50];
}add;

typedef struct test {
	char arr[5];
}str;

void menu(void);
void add_contact(int num, add *list);
void exchange(add *list, int a, int b);
void name_sort(add *list,int num);
int total(add *list);
int find_contact(add *list);
void delete_contact(add *list, int num);
void modify_contact(add *list);
void show_allcontact(add *list, int num);
int end_menu(add *list);
int judge_ifnum(char *num);

#endif
