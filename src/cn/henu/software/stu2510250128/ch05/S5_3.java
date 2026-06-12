package cn.henu.software.stu2510250128.ch05;

import java.util.Scanner;

public class S5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int upper = 0, lower = 0, digit = 0, other = 0;

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) upper++;
            else if (Character.isLowerCase(c)) lower++;
            else if (Character.isDigit(c)) digit++;
            else other++;
        }

        System.out.println("大写字母：" + upper + "个");
        System.out.println("小写字母：" + lower + "个");
        System.out.println("数字：" + digit + "个");
        System.out.println("其它字符：" + other + "个");
    }
}
