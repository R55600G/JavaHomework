package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

public class T1_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c;
        System.out.print("请输入数a:");
        a = scan.nextInt();
        System.out.print("请输入数b:");
        b = scan.nextInt();
        System.out.print("请输入数c:");
        c = scan.nextInt();
        int d = (a > b ? a : b);
        int e = (d > c ? d : c);
        System.out.println("最大的数是" + e);
        scan.close();
    }
}
