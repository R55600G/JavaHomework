package cn.henu.software.stu2510250128.ch05;

import java.util.Scanner;
import java.time.YearMonth;

public class S5_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        YearMonth ym = YearMonth.of(year, 2);
        System.out.println(year + "年的二月有" + ym.lengthOfMonth() + "天");
    }
}
