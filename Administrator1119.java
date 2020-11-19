package user;

import operation.*;

import java.util.Scanner;

public class Administrator extends User{
    public Administrator(String name) {
        super.name = name;
        super.iOperations = new IOperation[] {
                new AccessBook(),
                new AddBook(),
                new DeleteBook(),
                new PrintList(),
                new Exit()
        };
    }

    @Override
    int menu() {
        System.out.println("操作员"+name+"欢迎你登陆图书管理系统");
        System.out.println("请选择您需要的操作");
        System.out.println("========================");
        System.out.println("1、查找图书");
        System.out.println("2、添加图书");
        System.out.println("3、删除图书");
        System.out.println("4、打印图书");
        System.out.println("0、退出系统");
        System.out.println("========================");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
