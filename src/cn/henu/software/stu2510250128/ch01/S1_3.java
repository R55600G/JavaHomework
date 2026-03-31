package cn.henu.software.stu2510250128.ch01;

import java.util.Scanner;

public class S1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入整数n:");
        int n = sc.nextInt();
        if (n < 0)
            System.out.println("错误!");
        else {
            long m = 1;
            for (int i = 1; i <= n; i++) {
                m = m * i;
            }
            System.out.println(n + "的阶乘为:" + m);
        }
        sc.close();
    }
}
