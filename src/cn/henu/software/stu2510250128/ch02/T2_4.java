package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

public class T2_4 {
    public static void main(String[] args) {
        System.out.print("请输入公里数:");
        Scanner scan = new Scanner(System.in);
        double km = scan.nextDouble();
        if (km >= 0 && km <= 2)
            System.out.println("6元");
        else if (km > 2 && km <= 9) {
            System.out.println(1 + 5 + (km - 2) * 1.3 + "元");
        } else if (km > 9) {
            System.out.println(1 + 5 + 9.1 + 1 + (km - 9) * 2 + "元");
        } else
            System.out.println("输入有误");
        scan.close();
    }

}
