package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

public class T2_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入出生年月，用空格隔开(2017 4)");
        int year = scan.nextInt();
        int month = scan.nextInt();
        int day;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0)
                    day = 29;
                else
                    day = 28;
                break;
            default:
                System.out.println("输入错误");
                return;
        }
        System.out.println(year + "年" + month + "月有" + day + "天");
        scan.close();
    }
}
