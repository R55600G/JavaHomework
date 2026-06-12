package cn.henu.software.stu2510250128.ch05;

import java.util.Scanner;

public class S5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user, pwd, pwdConfirm, phone;

        while (true) {
            System.out.print("请输入用户名:");
            user = sc.nextLine();
            System.out.print("请输入密码:");
            pwd = sc.nextLine();
            System.out.print("请确认密码:");
            pwdConfirm = sc.nextLine();
            System.out.print("请输入手机号:");
            phone = sc.nextLine();

            if (pwd.equals(pwdConfirm)) {
                System.out.println("注册成功");
                break;
            } else {
                System.out.println("密码不一致，请重新注册");
            }
        }

        int attempts = 0;
        while (attempts < 3) {
            System.out.print("请输入登录用户名:");
            String loginUser = sc.nextLine();
            System.out.print("请输入登录密码:");
            String loginPwd = sc.nextLine();

            if (user.equals(loginUser) && pwd.equalsIgnoreCase(loginPwd)) {
                System.out.println("登录成功");
                try {
                    Runtime.getRuntime().exec("calc");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("密码错误，请重新输入！");
                }
            }
        }
        System.out.println("登录失败，无法再继续登录");
    }
}
