package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

public class T2_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("请输入用户名(长度不小于3):");
            String username = scan.next();

            System.out.print("请输入密码(长度不小于6):");
            String password = scan.next();

            System.out.print("确认密码:");
            String confirmPassword = scan.next();

            if (username.length() < 3) {
                System.out.println("提示：输入有误！用户名长度不能小于3。\n");
            } else if (password.length() < 6) {
                System.out.println("提示：输入有误！密码长度不能小于6。\n");
            } else if (!password.equals(confirmPassword)) {
                System.out.println("提示：输入有误！两次输入的密码不一致。\n");
            } else {
                System.out.println("恭喜，注册成功！");
                break;
            }
        }

        scan.close();
    }
}